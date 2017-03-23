package com.java.thread.concurrencyOfArt.chap1;

/**
 * 死锁
 * Created by ibm on 2017/3/23.
 */
public class DeadLockDemo {
    private static String A="A";
    private static String B="B";

    /**
     * 避免死锁的几种方法
     * 1.避免一个线程同时获取多个锁.
     * 2.避免一个线程在锁内同时占用多个资源，尽量保证每个锁只占用一个资源.
     * 3.尝试使用定时锁，使用lock.tryLock(timeout)来替代使用内部锁机制.
     * 4.对于数据库锁，加锁和解锁必须在一个数据库连接池里，否则会出现解锁失败的情况.
     * @param args
     */
    public static void main(String[] args){
        System.out.println("开始");
        new DeadLockDemo().deadLock();
        System.out.println("结束");
    }

    private void deadLock(){
        //线程1
        Thread thread1=new Thread(new Runnable() {
            public void run() {
                synchronized(A){
                    try {
                        Thread.currentThread().sleep(2000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    synchronized (B){
                      System.out.println("1");
                    }

                }
            }
        });
        //线程2
        Thread thread2=new Thread(new Runnable() {
            public void run() {
                synchronized (B){
                    synchronized (A){
                        System.out.println("2");
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
