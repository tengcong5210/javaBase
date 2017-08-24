package com.java.thread.concurrencyOfArt.chap5;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tengcongcong
 * @create 2017-08-22 11:31
 * @Version 1.0
 **/
public class BoundedQueueTest {

    private static final Logger LOGGER= LoggerFactory.getLogger(BoundedQueueTest.class);

    private BoundedQueue<String> queue=new BoundedQueue<String>(10);

    @Test
    public void testBoundedQueue() throws InterruptedException {
       LOGGER.info("=======testBoundedQueue【start】=====");


        Thread removeThread=new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        queue.recome();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        },"删除线程");
        removeThread.start();

        Thread.sleep(1000);
        LOGGER.info("=======testBoundedQueue【ing】=====");

        Thread addThread=new Thread(new Runnable() {
            public void run() {
                try {
                    for(int i=0;i<5;i++){
                        queue.add(i+"");
                    }
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        },"添加线程");
        addThread.start();
        LOGGER.info("=======testBoundedQueue【end】=====");
    }
}
