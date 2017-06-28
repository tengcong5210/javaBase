package com.java.tool;

import com.alibaba.fastjson.JSON;
import com.java.bean.DTO.ExcelParseResultDTO;
import com.java.bean.FileParseResult;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by ibm on 2017/5/28.
 */
public class ExcelTool {
    /**
     * 日志
     */
    private final static Logger LOGGER= LoggerFactory.getLogger(ExcelTool.class);
    private Workbook wb     = null;
    private SimpleDateFormat    sdf    = new SimpleDateFormat("yyyyMMdd");

    public ExcelTool(String path) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(path);
            wb = WorkbookFactory.create(inputStream);
        } catch (FileNotFoundException e) {
            LOGGER.error("文件没有找到，赶快确认！", e);
            throw new RuntimeException(e);
        } catch (IOException e) {
            LOGGER.error("流出现异常，尽快确认！", e);
            throw new RuntimeException(e);
        } catch (InvalidFormatException e) {
            LOGGER.error("流出现异常，尽快确认！", e);
            e.printStackTrace();
        } finally {
            closeInputStream(inputStream);
        }
    }

    public ExcelTool(InputStream in) {
        try {
            wb = WorkbookFactory.create(in);
        } catch (FileNotFoundException e) {
            LOGGER.error("文件没有找到，赶快确认！", e);
            throw new RuntimeException(e);
        } catch (InvalidFormatException e) {
            LOGGER.error("流出现问题", e);
            throw new RuntimeException(e);
        } catch (IOException e) {
            LOGGER.error("流出现异常，尽快确认！",e);
            throw new RuntimeException(e);
        } finally {
            closeInputStream(in);
        }
    }

    /**
     * 读取文件
     *
     * @param c
     * @param fileNames
     * @param sheetIndex 读取第几个sheetIndex
     * @param spkit 跳过多少行
     * @return
     */
    public <T> FileParseResult<T> getExcelData(Class<T> c, String[] fileNames, int sheetIndex, int spkit) {
        List<String[]> list = new ArrayList<String[]>();
        FileParseResult<T> result = new FileParseResult<T>();
        int columnNum = 0;
        Row row = null;
        String value = null;
        Sheet sheet = wb.getSheetAt(sheetIndex);
        if (sheet.getRow(0) != null) {
            columnNum = sheet.getRow(0).getLastCellNum() - sheet.getRow(0).getFirstCellNum();
        }
        int rowNum = sheet.getLastRowNum();//总行数
        if (rowNum == 0) {
            LOGGER.warn("读取的文件为空！");
            throw new RuntimeException("要读取的文件为空，请确认一遍！解析的文件为EXCEL文件。方法为：getExcelData");
        }
        if (spkit > rowNum + 1) {
            LOGGER.warn("读取的文件为空！");
            throw new RuntimeException("要读取的文件为空，请确认一遍！解析的文件为EXCEL文件。方法为：getExcelData");
        }
        if (fileNames.length != columnNum) {
            LOGGER.error("要赋值的列和导入的文件列不相同请检查！解析的文件为EXCEL文件需要的长度为：" + fileNames.length + ";实际的列长度为：" + columnNum);
            throw new RuntimeException("要赋值的列和导入的文件列不相同请检查！解析的文件为EXCEL文件需要的长度为：" + fileNames.length + ";实际的列长度为："
                    + columnNum);
        }

        if (columnNum > 0) {
            for (int k = spkit; k <= rowNum; k++) {

                row = sheet.getRow(k);
                if (null == row) {
                    break;
                }
                String[] singleRow = new String[columnNum];
                int n = 0;
                for (int i = 0; i < columnNum; i++) {
                    Cell cell = row.getCell(i, Row.CREATE_NULL_AS_BLANK);
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_BLANK:
                            singleRow[n] = "";
                            break;
                        case Cell.CELL_TYPE_BOOLEAN:
                            singleRow[n] = Boolean.toString(cell.getBooleanCellValue());
                            break;
                        //数值
                        case Cell.CELL_TYPE_NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                /*解决日期问题：
                                所有日期格式都可以通过getDataFormat()值来判断
                                yyyy-MM-dd-----	14
                                yyyy年m月d日---	31
                                yyyy年m月-------	57
                                m月d日  ----------	58
                                HH:mm-----------	20
                                h时mm分  -------	32*/
                                short format = cell.getCellStyle().getDataFormat();
                                LOGGER.info("日期格式类型："+format);
                                if(format == 14 || format == 31 || format == 57 || format == 58){
                                    //日期
                                    sdf = new SimpleDateFormat("yyyy-MM-dd");
                                }else if (format == 20 || format == 32) {
                                    //时间
                                    sdf = new SimpleDateFormat("HH:mm");
                                }
                                double varValue = cell.getNumericCellValue();
                                Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(varValue);
                                singleRow[n] = sdf.format(date);
                            } else {
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                String temp = cell.getStringCellValue();
                                if (StringUtils.isBlank(temp)) {
                                    temp = "";
                                }

                                // 则转换为BigDecimal类型的字符串
                                if (temp.indexOf(".") > -1) {
                                    singleRow[n] = String.valueOf(new Double(temp)).trim();
                                } else {
                                    singleRow[n] = temp.trim();
                                }
                            }
                            break;
                        case Cell.CELL_TYPE_STRING:
                            singleRow[n] = cell.getStringCellValue().trim();
                            break;
                        case Cell.CELL_TYPE_ERROR:
                            singleRow[n] = "";
                            break;
                        case Cell.CELL_TYPE_FORMULA:
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            singleRow[n] = cell.getStringCellValue();
                            if (value != null) {
                                singleRow[n] = value.replaceAll("#N/A", "").trim();
                            }
                            break;
                        default:
                            singleRow[n] = "";
                            break;
                    }
                    n++;
                }
                if ("".equals(singleRow[0])) {
                    continue;
                }//如果第一行为空，跳过
                list.add(singleRow);

            }
        }
        if (list.size() > 0) {
            try {
                return convertDataToDTO(c, list, fileNames);
            } catch (Exception e) {
                LOGGER.error("转换DTO异常，请检查!", e);
            }
        }
        return result;
    }

    /**
     * 导出excel
     *
     * @param c
     * @param list
     * @param feilds
     * @param sheetIndex 第几个sheet
     * @param spkit 跳过第几行
     */
    public <T> InputStream exportExcel(Class<T> c, List<T> list, String[] feilds, int sheetIndex, int spkit) {

        T obj;
        try {
            obj = c.newInstance();
        } catch (InstantiationException e1) {
            LOGGER.error("转换对象失败。。。" + e1.getMessage(), e1);
            throw new RuntimeException(e1);
        } catch (IllegalAccessException e1) {
            LOGGER.error("转换对象失败。。。" + e1.getMessage(), e1);
            throw new RuntimeException(e1);
        }
        int listLen = list.size();
        if (listLen == 0) {
            LOGGER.warn("要导出的数据为空，请确认！");
        }
        List<String[]> temp = new ArrayList<String[]>();
        int length = feilds.length;
        try {
            for (int i = 0; i < listLen; i++) {
                obj = list.get(i);
                for (int j = 0; j < length; j++) {
                    String[] arr = new String[length];
                    Field field = c.getDeclaredField(feilds[j]);
                    field.setAccessible(true);
                    Object val = field.get(obj);
                    if ("java.util.Date".equals(field.getType().getName())) {
                        arr[j] = sdf.format((Date) val);
                    } else {
                        arr[j] = (String) val;
                    }
                    temp.add(arr);
                }
            }
        } catch (Exception e) {
            LOGGER.error("message:" + e.getMessage(), e);
            throw new RuntimeException(e);
        }
        //写入excel
        Sheet sheet = wb.getSheetAt(sheetIndex);
        Row row = null;
        for (int i = 0; i < listLen; i++) {
            String[] arr = temp.get(i);
            row = sheet.getRow(spkit);
            for (int j = 0; j < length; j++) {
                Cell cell = row.getCell(j);
                if (cell == null) {
                    cell = row.createCell(j);
                }
                cell.setCellValue(arr[j]);
            }
        }
        ByteArrayOutputStream out = null;
        ByteArrayInputStream in = null;
        try {
            out = new ByteArrayOutputStream();
            out.flush();
            wb.write(out);
            in = new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            LOGGER.error("流出现异常，尽快确认！");
        } finally {
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    LOGGER.error("关闭流异常。。。：" + e.getMessage(), e);
                }
            }
        }
        return in;
    }

    /**
     * 往Excel的指定列写值
     *
     * @param sheetIndex 第几个工作簿
     * @param spkit 跳过行数
     * @param find 根据第几列来查查找
     * @param map
     */
    public <T> InputStream writeExcel(int sheetIndex, int spkit, int find, Map<Integer, Map<Integer, String>> map) {
        Row row = null;
        int columnNum = 0;
        Sheet sheet = wb.getSheetAt(sheetIndex);
        if (sheet.getRow(0) != null) {
            columnNum = sheet.getRow(0).getLastCellNum() - sheet.getRow(0).getFirstCellNum();
        }
        int rowNum = sheet.getLastRowNum();//总行数
        if (rowNum == 0) {
            LOGGER.error("读取的文件为空！");
            throw new RuntimeException("写入的文件不正确，请检查！要写入的文件为EXCEL文件,方法为：writeExcel");
        }
        if (columnNum > 0) {
            for (int i = spkit; i <= rowNum; i++) {
                row = sheet.getRow(i);//第几行
                if (null == row) {
                    break;
                }
                for (int j = spkit; j <= rowNum; j++) {
                    for (Map.Entry<Integer, Map<Integer, String>> entry : map.entrySet()) {
                        Cell cell = row.getCell(find, Row.CREATE_NULL_AS_BLANK);
                        String keyValue = null;
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_BLANK:
                                keyValue = "";
                                break;
                            case Cell.CELL_TYPE_BOOLEAN:
                                keyValue = Boolean.toString(cell.getBooleanCellValue());
                                break;
                            //数值
                            case Cell.CELL_TYPE_NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    keyValue = String.valueOf(cell.getDateCellValue());
                                } else {
                                    cell.setCellType(Cell.CELL_TYPE_STRING);
                                    String temp = cell.getStringCellValue();
                                    //判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
                                    if (temp.indexOf(".") > -1) {
                                        keyValue = String.valueOf(new Double(temp)).trim();
                                    } else {
                                        keyValue = temp.trim();
                                    }
                                }
                                break;
                            case Cell.CELL_TYPE_STRING:
                                keyValue = cell.getStringCellValue().trim();
                                break;
                            case Cell.CELL_TYPE_ERROR:
                                keyValue = "";
                                break;
                            case Cell.CELL_TYPE_FORMULA:
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                keyValue = cell.getStringCellValue();
                                if (keyValue != null) {
                                    keyValue = keyValue.replaceAll("#N/A", "").trim();
                                }
                                break;
                            default:
                                keyValue = "";
                                break;
                        }
                        if (null != keyValue && entry.getKey().toString().equals(keyValue)) {
                            for (Map.Entry<Integer, String> entry2 : entry.getValue().entrySet()) {
                                cell = row.getCell(entry2.getKey());//该行的列cell
                                if (cell == null) {
                                    cell = row.createCell(entry2.getKey());
                                }
                                try {
                                    cell.setCellValue(entry2.getValue());
                                } catch (Exception e) {
                                    LOGGER.error("写入数据失败！" + e.getMessage(), e);
                                    throw new RuntimeException("生产保单号失败！" + e.getMessage(), e);
                                }
                            }
                        }
                    }
                }
            }
        }
        ByteArrayOutputStream out = null;
        ByteArrayInputStream in = null;
        try {
            out = new ByteArrayOutputStream();
            wb.write(out);
            out.flush();
            in = new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            LOGGER.error("流出现异常，尽快确认！message:" + e.getMessage(), e);
            throw new RuntimeException(e);
        } finally {
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    LOGGER.error("关闭流失败..." + e.getMessage(), e);
                }
            }
        }
        return in;
    }


    private <T> FileParseResult<T> convertDataToDTO(Class<T> c, List<String[]> dataList, String[] fileNames)
            throws InstantiationException, IllegalAccessException {
        FileParseResult<T> result = new FileParseResult<T>();
        List<T> temp = new ArrayList<T>();
        int dataLength = dataList.size();
        T obj = null;

        StringBuffer errorDesc = new StringBuffer("");
        for (int i = 0; i < dataLength; i++) {
            try {
                obj = c.newInstance();
            } catch (Exception e) {
                LOGGER.error("convertDataToDTO实例化异常", e);
            }
            String[] data = dataList.get(i);
            boolean errorFlag = false;
            for (int j = 0; j < fileNames.length; j++) {
                try {
                    Field field = c.getDeclaredField(fileNames[j]);
                    field.setAccessible(true);
                    if ("java.util.Date".equals(field.getType().getName())) {
                        field.set(obj, data[j] == null ? null : sdf.parse(data[j]));
                    } else if ("java.lang.String".equals(field.getType().getName())) {
                        field.set(obj, data[j]);
                    }
                } catch (Exception e) {
                    int row = i + 1;
                    int col = j + 1;
                    errorDesc.append("第" + row + "行" + col + "列数格式错误;");
                    LOGGER.error("出现异常，尽快确认！",e);
                    errorFlag = true;
                    continue;
                }
            }
            if (!errorFlag) {
                temp.add(obj);
            }
        }
        result.setErrorDesc(errorDesc.toString());
        result.setResultList(temp);
        result.setTotal(dataLength);
        result.setSuccess(true);
        return result;
    }



    /**
     * 关闭输入流
     *
     * @param in
     */
    private void closeInputStream(InputStream in) {
        close(in, null);
    }

    private void close(InputStream in, OutputStream out) {
        try {
            if (null != in) {
                in.close();
            }
            if (null != out) {
                out.close();
            }
        } catch (Exception e) {
            LOGGER.error("关闭流失败。。" + e.getMessage(), e);
        }
    }


    public Workbook getWb() {
        return wb;
    }

    public static void main(String[] args) {
        String path = "D:\\workspaceIdea\\excelReadTestFile\\readTest.xlsx";
        InputStream inputStream = null;
        FileParseResult<ExcelParseResultDTO> result=new FileParseResult<ExcelParseResultDTO>();
        String[] fileNames={"id","name","age","salary","dateOnBoard"};
        try {
            System.out.println("文件路径:"+path);
            inputStream = new FileInputStream(new File(path));
            ExcelTool tool = new ExcelTool(inputStream);
            result=tool.getExcelData(ExcelParseResultDTO.class,fileNames,0,1);
           LOGGER.info("结果:"+ JSON.toJSONString(result));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
