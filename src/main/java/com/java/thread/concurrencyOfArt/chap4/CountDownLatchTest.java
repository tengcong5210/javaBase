package com.java.thread.concurrencyOfArt.chap4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch构造器中的计数值（count）实际上就是闭锁需要等待的线程数量。这个值只能被设置一次，
 * 而且CountDownLatch没有提供任何机制去重新设置这个计数值。
 * 与CountDownLatch的第一次交互是主线程等待其他线程。
 * 主线程必须在启动其他线程后立即调用CountDownLatch.await()方法。
 * 这样主线程的操作就会在这个方法上阻塞，直到其他线程完成各自的任务。
 * 其他N 个线程必须引用闭锁对象，因为他们需要通知CountDownLatch对象，他们已经完成了各自的任务。
 * 这种通知机制是通过 CountDownLatch.countDown()方法来完成的；每调用一次这个方法，在构造函数中初始化的count值就减1。
 * 所以当N个线程都调 用了这个方法，count的值等于0，然后主线程就能通过await()方法，恢复执行自己的任务。
 * Created by ibm on 2017/4/16.
 */
public class CountDownLatchTest {
    //运动会赛场上，有10名运动员参加100米短跑，裁判员一声：“预备”，所有参赛者站在各自的赛道就绪，
    // 随着裁判的一声令下，个运动员直接飞奔出去，直到最后一名选手跑完，裁判员又一声令下：比赛结束。
    static CountDownLatch startLatch=new CountDownLatch(1);
    static CountDownLatch endLatch;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+" 各就各位，预备 "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
        int threadCount=10;
        endLatch =new CountDownLatch(threadCount);
        for(int i=0;i<threadCount;i++){
            Thread thread=new Thread(new ThreadRunner(),i+"");
            thread.start();
        }
        System.out.println(Thread.currentThread().getName()+" 开始，go.go.go. "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
        startLatch.countDown();
        endLatch.await();
        System.out.println(Thread.currentThread().getName()+" 比赛结束 "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }

    static class ThreadRunner implements Runnable{
        public void run() {
            try {
                startLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" 号选手开跑 "+new SimpleDateFormat("HH:mm:ss").format(new Date()));
            endLatch.countDown();
        }
    }
}
