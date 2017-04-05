package com.java.thread.concurrencyOfArt.chap4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 线程的优先级
 * Created by ibm on 2017/4/4.
 */
public class Priority {
    private static volatile boolean notStart=true;
    private static volatile boolean notEnd=true;

    public static void main(String[] args) throws Exception {
        List<Job> jobs=new ArrayList<Job>();
        for(int i=0;i<10;i++){
            int priority=i<5?Thread.MIN_PRIORITY:Thread.MAX_PRIORITY;
            Job job=new Job(priority);
            jobs.add(job);
            Thread thread=new Thread(job,"Thread"+i);
            thread.start();
        }
        notStart=false;
        TimeUnit.SECONDS.sleep(10);
        notEnd=false;
        for (Job job:jobs){
            System.out.println("Job priority:"+job.priotiry+",count:"+job.jobCount);
        }
    }

    static class Job implements Runnable{

        private int priotiry;
        private long jobCount;

        public Job(int priotiry){
            this.priotiry=priotiry;
        }

        public void run(){
            while (notStart){
                /*yield()没有参数
                sleep 方法使当前运行中的线程睡眠一段时间，进入不可以运行状态，这段时间的长短是由程序设定的，
                yield方法使当前线程让出CPU占有权，但让出的时间是不可设定的。
                yield()也不会释放锁标志。
                实际上，yield()方法对应了如下操作；
                先检测当前是否有相同优先级的线程处于同可运行状态，如有，
                则把CPU的占有权交给次线程，否则继续运行原来的线程，
                所以yield()方法称为“退让”，它把运行机会让给了同等级的其他线程。

                sleep 方法允许较低优先级的线程获得运行机会，但yield（）方法执行时，
                当前线程仍处在可运行状态，所以不可能让出较低优先级的线程此时获取CPU占有权。
                在一个运行系统中，如果较高优先级的线程没有调用sleep方法，也没有受到I/O阻塞，
                那么较低优先级线程只能等待所有较高优先级的线程运行结束，方可有机会运行。

                yield()只是使当前线程重新回到可执行状态，
                所有执行yield()的线程有可能在进入到可执行状态后马上又被执行，
                所以yield()方法只能使同优先级的线程有执行的机会。*/
                Thread.yield();
            }
            while (notEnd){
                Thread.yield();
                jobCount++;
            }
        }
    }

}
