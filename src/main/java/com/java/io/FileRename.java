package com.java.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 将指定目录下的文件重命名
 * 
 * @author linco lee
 */
public class FileRename {
    public static String[]     units    = { "", "十", "百", "千", "万", "十万", "百万", "千万", "亿", "十亿", "百亿", "千亿", "万亿" };
    public static char[]       numArray = { '零', '一', '二', '三', '四', '五', '六', '七', '八', '九' };
    public static final String PATHNAME = "D:\\myStudyVideo\\shengsiyuan\\JAVASE";

    /**
     * 将阿拉伯数字转中文数字
     * 
     * @param num
     * @return
     */
    public static String foematInteger(int num) {
        char[] val = String.valueOf(num).toCharArray();
        int len = val.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            String m = val[i] + "";
            int n = Integer.valueOf(m);
            boolean isZero = n == 0;
            String unit = units[(len - 1) - i];
            if (isZero) {
                if ('0' == val[i - 1]) {
                    // not need process if the last digital bits is 0
                    continue;
                } else {
                    // no unit for 0
                    if (len > 2) {//3位数才有零，2位数没有零，为了避免10=十零,20=二十零
                        sb.append(numArray[n]);
                    }
                }
            } else {
                sb.append(numArray[n]);
                sb.append(unit);
            }
        }
        return sb.toString();
    }

    /**
     * 文件重命名
     * 
     * @param pathname
     */
    public static void renameFile(String pathname) {
        File srcFile = new File(pathname);
        String[] srcFilenames = srcFile.list();
        File destFile = null;
        String filename = "";
        String targetStr = "";
        Integer replacement;
        Map<String, Integer> numMap = getNumMap();
        for (String name : srcFilenames) {
            destFile = new File(srcFile, name);
            filename = destFile.getName();
            //            targetStr = destFile.getName().substring(destFile.getName().indexOf("第") + 1,
            //                    destFile.getName().indexOf("讲"));//要被替换的字符串
            //            System.out.println("targetStr:" + targetStr);
            //            replacement = numMap.get(targetStr);//替换成新的字符
            //            if (StringUtils.isBlank(String.valueOf(replacement))) {
            //                continue;
            //            } else {
            //                destFile.renameTo(new File(srcFile.getAbsolutePath() + File.separator
            //                        + filename.replace(targetStr, String.valueOf(replacement))));
            //            }
            destFile.renameTo(new File(srcFile.getAbsolutePath() + File.separator
                    + filename.replace("[北京圣思园Java培训教学视频]", "")));
        }

    }

    /**
     * 获取文件列表
     * 
     * @param pathname
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> getFilenameList(String pathname) {
        List<T> fileList = new ArrayList<T>();
        File file = new File(pathname);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            fileList = (List<T>) Arrays.asList(files);
        }
        return fileList;
    }

    /**
     * 获取中文数字和阿拉伯数字对应的map
     * 
     * @return
     */
    public static Map<String, Integer> getNumMap() {
        Map<String, Integer> numMap = new HashMap<String, Integer>();
        //        List<File> fileList = getFilenameList(PATHNAME);
        for (int i = 1; i < 200; i++) {
            String key = foematInteger(i);
            numMap.put(key, i);
        }
        return numMap;
    }

    public static void main(String[] args) {
        //        String pathname = "D:\\myStudyVideo\\shengsiyuan\\src";
        renameFile(PATHNAME);
        System.out.println("success");

        String str = foematInteger(118);
        System.out.println(str);

        Map<String, Integer> numMap = getNumMap();
        Set<Entry<String, Integer>> setEntry = numMap.entrySet();
        for (Entry<String, Integer> entry : setEntry) {
            System.out.println("key:" + entry.getKey() + ";value:" + entry.getValue());
        }
    }
}
