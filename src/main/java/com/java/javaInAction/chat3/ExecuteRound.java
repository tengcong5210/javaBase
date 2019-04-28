package com.java.javaInAction.chat3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

/**
 * @创建人 tengcc
 * @创建时间 2019/4/28
 * @描述
 */
public class ExecuteRound {

    public static void main(String[] args) throws Exception{


        //读取一行数据
        String oneLine=processFile();
        System.out.println("一行文件内容:"+oneLine);

        //lambda表达式 读取一行数据
        String lambdaOneLine=processFile( (BufferedReader b)->b.readLine() );
        System.out.println("lambda一行文件内容:"+lambdaOneLine);

        //lambda表达式 读取二行数据
        String lambdaTwoLine=processFile( (BufferedReader b)->b.readLine()+b.readLine() );
        System.out.println("lambda两行行文件内容:"+lambdaTwoLine);
    }

    /**
     * 读取一行数据
     * @return
     * @throws IOException
     */
    public static String processFile() throws IOException {
        String filePath=ExecuteRound.class.getClassLoader().getResource("data.txt").getPath();
        System.out.println("文件路径:"+filePath);
        try (BufferedReader br=new BufferedReader(new FileReader(filePath))){
            return br.readLine();
        }
    }

    /**
     *  传递函数接口(lambda 表达是是 函数接口的抽象实现 ; 也是从内名内部类的另外表达方式)
     * @param processor
     * @return
     * @throws IOException
     */
    public static String processFile(BufferedReaderProcessor processor)throws IOException{
        String filePath=ExecuteRound.class.getClassLoader().getResource("data.txt").getPath();
        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
            return processor.process(br);
        }
    }


}