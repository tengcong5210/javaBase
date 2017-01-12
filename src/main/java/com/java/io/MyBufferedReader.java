package com.java.io;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 缓冲字符流
 * 
 * @author linco lee
 */
public class MyBufferedReader {
    private Reader reader = null;

    public MyBufferedReader(Reader r) {
        this.reader = r;
    }

    public String myReadLine() throws IOException {
        //step1:创建临时容器
        StringBuffer sb = new StringBuffer();
        int ch = 0;
        while ((ch = reader.read()) != -1) {
            if (((char) ch) == '\r') {
                continue;
            }
            if (((char) ch) == '\n') {
                return sb.toString();
            } else {
                sb.append((char) ch);
            }
        }

        return sb.length() == 0 ? null : sb.toString();
    }

    public void myClose() throws IOException {
        if (reader != null) {
            reader.close();
        }
    }

    public static void main(String[] args) {
        try {
            MyBufferedReader mybuf = new MyBufferedReader(new FileReader("D:/home/测试文件/read.txt"));
            String line = null;
            while ((line = mybuf.myReadLine()) != null) {
                System.out.println("line:" + line);
            }
            mybuf.myClose();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
