package com.java.thread.concurrencyOfArt.chap4;

import com.java.thread.concurrencyOfArt.utils.SleepUtils;

import java.util.concurrent.TimeUnit;

/**
 * 线程中断
 * 结论：抛出Interrupted的方法（如Thread.sleep）,在方法抛出InterruptedException之前，
 * java虚拟机会先将该线程的中断标识清除。
 * 一直忙碌运作的线程，中断标识没有被清除（因为该线程中没有抛出InterruptedException异常）
 * Created by ibm on 2017/4/9.
 */
public class Interrupted {
   public static void main(String[] args) throws Exception {
       //sleepThread不停的尝试睡眠
       Thread sleepThread=new Thread(new SleepRunner(),"SleepRunner");
       sleepThread.setDaemon(true);
       //busyThread不停的运行
       Thread busyThread=new Thread(new BusyRunner(),"bussyRunner");
       busyThread.setDaemon(true);
       //线程启动
       sleepThread.start();
       busyThread.start();
       //休眠5秒，让sleepThread和busyThread充分运行
       TimeUnit.SECONDS.sleep(5);
       //线程中断
       sleepThread.interrupt();
       busyThread.interrupt();

       System.out.println("SleepThread interrupted is "+sleepThread.isInterrupted());
       System.out.println("BusyThread interrupted is "+busyThread.isInterrupted());

       SleepUtils.second(2);

   }

   static class SleepRunner implements Runnable{
       public void run() {
           while (true){
               SleepUtils.second(10);
           }
       }
   }

   static class BusyRunner implements Runnable{
       public void run() {
           while (true){

           }
       }
   }
}
