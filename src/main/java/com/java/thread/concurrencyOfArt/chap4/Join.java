package com.java.thread.concurrencyOfArt.chap4;

import java.util.concurrent.TimeUnit;

/**
 * thread.join()方法表示当前线程A等待thread线程终止后才从thread.join()返回
 * 本示例：创建10个线程、编号0-9,每个线程调用前一个线程的join()方法。
 * 也就是线程0结束了，线程1才能从join()方法中返回，而线程0需要等待main线程结束
 * Created by ibm on 2017/4/15.
 */
public class Join {
    public static void main(String[] args) throws InterruptedException {
        //当前main线程（即主线程）
        Thread previous=Thread.currentThread();
        for(int i=0;i<10;i++){
            Thread thread=new Thread(new Domino(previous),i+"");
            thread.start();
            previous=thread;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName()+" terminate.");
    }
    static class Domino implements Runnable{
        //前驱线程
        private Thread previous;
        public Domino(Thread previous){
            this.previous=previous;
        }
        public void run() {
            System.out.println(Thread.currentThread().getName()+" start");
            try {
                previous.join();//必须等到previous终止后才能从join()方法返回。即释放锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" terminate");
        }
    }
}
