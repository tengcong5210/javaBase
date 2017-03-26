package com.java.thread.concurrencyOfArt.chap2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger用于原子操作更新的int值
 * 关于AtomicInteger类的compareAndSet方法请查看http://www.blogjava.net/mstar/archive/2013/04/24/398351.html博客，或自行查找
 * Created by ibm on 2017/3/26.
 */
public class Counter {
    private AtomicInteger atomicI=new AtomicInteger(0);
    private int i=0;

    public static void main(String[] args){
        final Counter cas=new Counter();
        List<Thread> ts=new ArrayList<Thread>(600);
        long start=System.currentTimeMillis();
        //创建100个线程
        for(int j=0;j<100;j++){

            Thread t=new Thread(new Runnable() {
                public void run() {
                    for(int i=0;i<10000;i++){
                        cas.count();
                        cas.safeCount();
                    }
                }
            });
            ts.add(t);
        }
        //开启线程
        for(Thread t:ts){
            t.start();
        }
        //等待所有线程执行完
        for(Thread t:ts){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("noSafe:"+cas.i);
        System.out.println("safe:"+cas.atomicI.get());
        System.out.println(System.currentTimeMillis()-start);
    }

    /**
     * 安全计数器 使用cas实现
     */
    private void safeCount(){
        for(;;){
            int i=atomicI.get();
            boolean suc=atomicI.compareAndSet(i,++i);
            if(suc){
                break;
            }
        }
    }

    /**
     * 非线程安全计数器（思考：该方法加上Synchronized是不是就安全了呢，同时与使用AtomicInteger有啥区别呢？）
     */
    private void count(){
        i++;
    }
}
