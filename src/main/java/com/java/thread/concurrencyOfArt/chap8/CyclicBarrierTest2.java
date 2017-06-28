package com.java.thread.concurrencyOfArt.chap8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier还提供一个更高的构造函数CyclicBarrier(int parties,Runnable barrierAction),
 * 用于在线程到达屏障时，优先执行BarrierAction.
 * Created by ibm on 2017/5/30.
 */
public class CyclicBarrierTest2 {

    private static final Logger LOGGER= LoggerFactory.getLogger(CyclicBarrierTest2.class);

    static CyclicBarrier c=new CyclicBarrier(2,new A());

    public static void main(String[] args){

        new Thread(new Runnable() {
            public void run() {
                try {
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }).start();

        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(2);

    }

    static class A implements Runnable{

        public void run() {
            System.out.println(3);
        }
    }
}
