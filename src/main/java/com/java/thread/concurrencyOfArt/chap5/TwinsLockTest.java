package com.java.thread.concurrencyOfArt.chap5;

import com.java.thread.concurrencyOfArt.utils.SleepUtils;
import org.junit.Test;

import java.util.concurrent.locks.Lock;

/**
 * Created by ibm on 2017/4/25.
 */
public class TwinsLockTest {
    @Test
    public void test(){
        final Lock lock=new TwinsLock();
        class Worker extends Thread{
            @Override
            public void run() {
                while (true){
                    lock.lock();
                    try {
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }
        //启动10个线程
        for(int i=0;i<10;i++){
            Worker w=new Worker();
            w.setDaemon(true);
            w.start();
        }

        for(int i=0;i<10;i++){
            SleepUtils.second(1);
            System.out.println("aaa:"+i);
        }
    }
}
