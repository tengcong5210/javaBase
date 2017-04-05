package com.java.thread.concurrencyOfArt.chap4;

import com.java.thread.concurrencyOfArt.utils.SleepUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 守护线程
 * Created by ibm on 2017/4/5.
 */
public class Daemon {
    private static final Logger LOGGER= LoggerFactory.getLogger(Daemon.class);
    public static void main(String[] args){
        LOGGER.info("开始守护线程");
        Thread thread=new Thread(new DaemonRunner(),"DaemonRunner");
        thread.setDaemon(true);
        thread.start();
        LOGGER.info("结束守护线程");
    }

    static class DaemonRunner implements Runnable{

        public void run() {
            try {
                SleepUtils.second(10);
            }finally {
                System.out.println("DaemonThread finaly run.");
            }
        }
    }
}
