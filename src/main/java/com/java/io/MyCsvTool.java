package com.java.io;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyCsvTool {

    public void readFile(String pathname, String encoding) {
        BufferedReader bf = null;
        try {
            DataInputStream din = new DataInputStream(new FileInputStream(new File(pathname)));
            bf = new BufferedReader(new InputStreamReader(din, encoding));
            String readLine = null;
            while ((readLine = bf.readLine()) != null) {
                System.out.println("readLine:" + readLine);
                String[] strs = readLine.split("\\s");
                System.out.println(strs.length);
                for (int i = 0; i < strs.length; i++) {
                    System.out.println("column:" + i + ":" + strs[i]);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != bf) {
                try {

                    bf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        MyCsvTool my = new MyCsvTool();
        String pathname = "D:\\home\\employee\\所有通过数据_page1.txt", encoding = "GBK";
        my.readFile(pathname, encoding);
    }

}
