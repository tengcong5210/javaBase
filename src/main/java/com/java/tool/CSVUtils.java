package com.java.tool;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CSVUtils {
    public static void createCSVFile(String outPutPath, String fileName) throws IOException {
        File csvFile = null;
        File file = new File(outPutPath);
        if (!file.exists()) {
            file.mkdir();
        }
        //定义文件名格式并创建       
        csvFile = File.createTempFile(fileName, ".csv", new File(outPutPath));
        System.out.println("csvFile：" + csvFile);
    }

    public static void createCSVFile(String fileName) throws IOException {
        File filePath = new File(fileName);

        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();
        }
        if (!filePath.exists()) {
            filePath.createNewFile();
        }

        System.out.println("csvFileaa：" + filePath);
    }

    public static File readFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("filePath is not exists ");
        }
        File[] files = file.listFiles();
        List<File> fileList = Arrays.asList(files);
        for (int i = 0; i < fileList.size(); i++) {
            System.out.println("文件名：" + fileList.get(i).getName());
            System.out.println("文件路径：" + fileList.get(i).getAbsolutePath());
            System.out.println("文件路径2：" + fileList.get(i).getPath());
        }

        return file;
    }

    public static void main(String[] args) {
        //        String path = "c:/export/";
        //        String path = System.getProperty("user.dir") + File.separator + "csvFile";
        //        String path = System.getProperty("user.dir") + File.separator + "csvFile" + File.separator + "RegResult_"
        //                + System.currentTimeMillis() + ".csv";
        String path = System.getProperty("user.dir") + File.separator + "csvFile";
        //            createCSVFile(path);
        try {
            readFile(path);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
