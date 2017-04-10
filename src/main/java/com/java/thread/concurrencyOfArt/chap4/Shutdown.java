package com.java.thread.concurrencyOfArt.chap4;

import java.util.concurrent.TimeUnit;

/**
 * 安全终止线程
 * Created by ibm on 2017/4/9.
 */
public class Shutdown {
    public static void main(String[] args)throws Exception{
        //线程1
        Thread one=new Thread(new Runner(),"countThreadOne");
        one.start();
        //睡眠1秒，main线程对one进行中断，是one能够感知中断而结束
        TimeUnit.SECONDS.sleep(1);
        one.interrupt();

        //线程2
        Runner runner=new Runner();
        Thread two=new Thread(runner,"contThreadTwo");
        two.start();
        //睡眠1秒，main线程对two进行取消，是two能够感知中断而结束
        TimeUnit.SECONDS.sleep(1);
        runner.cancel();
    }

   private static class Runner implements Runnable{
      private long i;
      private volatile boolean on=true;

       public void run() {
           while(on&&!Thread.currentThread().isInterrupted()){
               i++;
           }
           System.out.println("Count i="+i);
       }
       public void cancel(){
           on=false;
       }
   }
}
