package com.java.thread.concurrencyOfArt.chap8;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch允许一个或多个线程等待其他线程完成操作
 * Created by ibm on 2017/5/28.
 */
public class SimpleCountDownLatchTest {
    /**
     * 日志
     */
    private static final Logger LOGGER= LoggerFactory.getLogger(SimpleCountDownLatchTest.class);


    /**
     * 一个线程中使用CountDownLatch
     * @throws InterruptedException
     */
    @Test
    public void testOneThreadUseCountDown() throws InterruptedException {
        //初始化2个计数器,如果你想等待N个节点，这里就传N
        final CountDownLatch c=new CountDownLatch(2);
        LOGGER.info("====0");
        new Thread(new Runnable() {
            public void run() {
                LOGGER.info("====1");
                c.countDown();//当countDown被调用时，N就会减1.
                LOGGER.info("====2");
                c.countDown();
            }
        }).start();
        c.await();//当await()方法被调用时，当前线程会被阻塞
        LOGGER.info("====3");
    }

    /**
     * 多个线程中使用CountDownLatch
     */
    @Test
    public void testMultiThreadUseCountDown() throws InterruptedException {
        CountDownLatch startCount=new CountDownLatch(1);
        CountDownLatch endCount=new CountDownLatch(3);
        LOGGER.info("====0");
        for(int i=0;i<3;i++){
            Thread thread=new Thread(new WorkerThread(startCount,endCount),i+"");
            thread.start();
        }
//        startCount.countDown();
        endCount.await();//调用await()方法阻塞当前线程
        LOGGER.info("====2");

    }
}

class WorkerThread implements Runnable{
    private static final Logger LOGGER= LoggerFactory.getLogger(WorkerThread.class);

    private CountDownLatch startCount;
    private CountDownLatch endCount;

    public WorkerThread(){

    }
    public WorkerThread(CountDownLatch startCount,CountDownLatch endCount){
        this.startCount=startCount;
        this.endCount=endCount;
    }
    public void run() {
        LOGGER.info(Thread.currentThread().getName()+"运行中(start)......."+new Date());
//        try {
//            startCount.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        LOGGER.info(Thread.currentThread().getName()+"运行中(end)......."+new Date());
        endCount.countDown();//countDown方法调用N就会减1

    }
}
