package com.java.thread.concurrencyOfArt.chap8;

import com.alibaba.fastjson.JSON;
import com.java.bean.DTO.ExcelParseResultDTO;
import com.java.bean.FileParseResult;
import com.java.tool.ExcelTool;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * 使用countDownLatch解析一个Excel里的多个sheet的数据.
 * 每个线程解析一个sheet里的数据，等到所有的sheet都解析完之后，程序需要提示解析完成。
 * Created by ibm on 2017/5/28.
 */
public class CountDownLatchInAction {
    /**
     * 日志
     */
    private static final Logger LOGGER= LoggerFactory.getLogger(CountDownLatchInAction.class);

    @Test
    public void testMultiThreadResolveExcel() throws InterruptedException {

        String path = "D:\\workspaceIdea\\excelReadTestFile\\readTest.xlsx";
        ExcelTool excelTool=new ExcelTool(path);
        Workbook wb=excelTool.getWb();
        if(wb==null){
          LOGGER.info("没有要解析的数据!");
          return;
        }
        int sheetsNum=wb.getNumberOfSheets();
        LOGGER.info("工作簿数："+sheetsNum);

        final CountDownLatch countDownLatch=new CountDownLatch(sheetsNum);
        final String[] fileNames={"id","name","age","salary","dateOnBoard"};
        LOGGER.info("开始.........");
        for(int i=0;i<sheetsNum;i++){
           Thread thread=new Thread(new ExcelWorker(countDownLatch,excelTool,fileNames,i),"ExcelWorker_"+i);
           thread.start();
        }
        countDownLatch.await();//阻塞当前线程，直到N变为零
        LOGGER.info("结束,解析完成.........");

    }

}

/**
 * excel工作线程
 */
class ExcelWorker implements Runnable{
    private static final Logger LOGGER= LoggerFactory.getLogger(ExcelWorker.class);
    public static final int SPKIT=1;
    private CountDownLatch countDownLatch;
    private ExcelTool excelTool;
    private int sheetNum;
    private String[] fileNames;

    public ExcelWorker(){

    }
    public ExcelWorker(CountDownLatch countDownLatch,ExcelTool excelTool,String[] fileNames,int sheetNum){
        this.countDownLatch=countDownLatch;
        this.excelTool=excelTool;
        this.fileNames=fileNames;
        this.sheetNum=sheetNum;
    }

    public void run() {
        FileParseResult<ExcelParseResultDTO> result=new FileParseResult<ExcelParseResultDTO>();
        try {
            result=excelTool.getExcelData(ExcelParseResultDTO.class,fileNames,sheetNum,SPKIT);
            LOGGER.info(Thread.currentThread().getName()+"执行结果:"+ JSON.toJSONString(result));
            //countDownLatch.countDown();countDown()方法被调用时N会减1，但不能写在此处，要写在finally代码块中，防止异常后不会减1，导致一直阻塞
        } catch (Exception e) {
            LOGGER.error(Thread.currentThread().getName()+"读取异常",e);
        }finally {
            countDownLatch.countDown();//正确的写法，异常后也会减1
        }

    }
}
