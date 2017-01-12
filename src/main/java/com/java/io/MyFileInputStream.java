package com.java.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyFileInputStream {

    public void readFile(String pathname) {
        InputStream in = null;
        try {
            in = new FileInputStream(pathname);
            int data = -1;
            byte[] bytes = new byte[1024];
            while ((data = in.read(bytes)) != -1) {
                System.out.println("data:" + new String(bytes, 0, data, "GBK"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String pathname = "D:/home/测试文件/read.txt";
        MyFileInputStream myIn = new MyFileInputStream();
        myIn.readFile(pathname);

    }
}
