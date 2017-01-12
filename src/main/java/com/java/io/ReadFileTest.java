package com.java.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFileTest {
    public static void main(String[] args) throws IOException {
        System.out.println("start");
        String fileName = "D:\\apply_nos2.txt";
        File file = new File(fileName);
        BufferedReader bufR = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String lineStr = null;
        StringBuilder sb = new StringBuilder();
        while ((lineStr = bufR.readLine()) != null) {
            String[] array = lineStr.split("\\;");
            System.out.println("a:" + array.length + ";b:" + (array.length / 100));
            sb.append("(");
            for (int i = 700; i < array.length; i++) {
                sb.append("'").append(array[i]).append("',");

            }
            sb.append(")");
            System.out.println("ddddddddd:" + sb.toString());
        }
        bufR.close();
        System.out.println("end");
    }
}
