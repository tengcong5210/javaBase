package com.java.thread;

import java.util.concurrent.TimeUnit;

public class FileSearchTest {
    public static void main(String[] args) {
        FileSearch seracher = new FileSearch("C:\\Users\\zxn", "antx.properties");
        Thread thread = new Thread(seracher);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
