package com.java.thread.concurrencyOfArt.chap8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier字面意思是循环使用的屏障，其可以让一组线程到达一个屏障（也可叫同步点）
 * 时被阻塞，直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续运行。
 * Created by ibm on 2017/5/30.
 */
public class CyclicBarrierTest {

    private static final Logger LOGGER= LoggerFactory.getLogger(CyclicBarrierTest.class);


    //默认构造方法CyclicBarrier(int parties),参数标识屏障拦截的线程数量，
    //每个线程调用await方法告诉CyclicBarrier我已经到达了屏障，然后当前线程被阻塞
    //如果将new CyclicBarrier(3)，则主线程和子线程永远等待，因为没有第三个线程执行await方法.
    //即没有第三个线程到达屏障，所以之前到达屏障的两个线程都不会继续执行。
    static CyclicBarrier c=new CyclicBarrier(2);

    public static void main(String[] args){
        //创建一个新线程
        new Thread(
                new Runnable() {

                    public void run() {
                        LOGGER.info(Thread.currentThread().getName()+" is runing");
                        try {
                            c.await();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println(1);
                    }
                }
        ).start();
        //主线程main
        LOGGER.info(Thread.currentThread().getName()+" is runing");
        try {
            c.await();//告诉CyclicBarrier已到达屏障，当前线程被阻塞.
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }
}
