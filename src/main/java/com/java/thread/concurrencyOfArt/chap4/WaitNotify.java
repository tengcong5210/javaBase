package com.java.thread.concurrencyOfArt.chap4;

import com.java.thread.concurrencyOfArt.utils.SleepUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *等待/通知机制：是指一个线程A调用了对象O的wait()方法进入等待状态，而另外一个线程B调用了对象O的notify/notifyAll()方法，
 * 线程A收到通知后从对象O的wait()方法返回，进而执行后续操作。
 * wait()方法：调用该方法的线程进入Waiting状态，只有等待另外线程的通知或者被中断才会返回，需要注意的是：调用wait()方法后，会释放对象的锁。
 * Created by ibm on 2017/4/10.
 */
public class WaitNotify {

    static boolean flag=true;
    static Object lock=new Object();

    public static void main(String[] args)throws Exception{

        Thread waitThread=new Thread(new Wait(),"WaitThread");
        waitThread.start();

        TimeUnit.SECONDS.sleep(1);

        Thread notifyThread=new Thread(new Notify(),"Notifythread");
        notifyThread.start();



    }
    static class Wait implements Runnable{
        public void run() {
            //对lock对象加锁
            synchronized (lock){
                //当条件不满足时，继续wait,同时释放了lock的锁
                while (flag){
                    try {
                        System.out.println(Thread.currentThread()+"flag is true,wait@"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread()+"flag is false,running@"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }
    static class Notify implements Runnable{
        public void run() {
            //加锁,拥有lock的锁
            synchronized (lock){
                //获取lock的锁，然后进行通知，通知时不会释放lock的锁。
                //直到当前线程释放了lock后，WaitThread才能从wait方法中返回
                System.out.println(Thread.currentThread()+"hold lock.notify @"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag=false;
                SleepUtils.second(5);
            }
            //再次加锁
            synchronized (lock){
                System.out.println(Thread.currentThread()+"hold lock again.sleep @"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                SleepUtils.second(5);
            }
        }
    }
}
