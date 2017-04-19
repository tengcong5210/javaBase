package com.java.thread.concurrencyOfArt.chap5;

import java.util.concurrent.locks.Lock;

/**
 * Created by ibm on 2017/4/19.
 */
public class MutexTest {
    static int count=0;
    static Lock myLock=new Mutex();
    public static void main(String[]args){
        System.out.println("开始");
        for(int i=0;i<5;i++){
            Thread thread=new Thread(new MyRunner(),"Thread_"+i);
            thread.start();
        }
        System.out.println("结束");

    }
    static  class MyRunner implements Runnable{

        public void run() {
            myLock.lock();
            try {
                count++;
                System.out.println(Thread.currentThread().getName()+";count="+count);
            }finally {
                myLock.unlock();
            }

        }
    }
}
