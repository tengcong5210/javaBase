package com.java.javaInAction.chat2;

public class Thread8 {

    public static void main(String[] args) {
        //传统方式创建线程
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+":hello world");
            }
        });

        t.start();

        //lambda创建线程
        Thread t2=new Thread(()->System.out.println(Thread.currentThread().getName()+":hello world2"));
        t2.start();

        System.out.println(Thread.currentThread().getName()+".......over........");
    }
}
