package com.java.thread.concurrencyOfArt.chap4;

import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal的使用
 * 该类通过ThreadLocal类计算业务方法的耗时，该类可以作为平常工作中的工具类
 * Created by ibm on 2017/4/15.
 */
public class Profiler {
    private static final ThreadLocal<Long> TIME_THREADLOCAL=new ThreadLocal<Long>(){
       protected Long initialValue(){
            return System.currentTimeMillis();
       }
    };

    public static final void begin(){
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end(){
        return System.currentTimeMillis()-TIME_THREADLOCAL.get();
    }
}

class ProfilerTest{
    public static void main(String[] args) throws InterruptedException {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Cost:"+Profiler.end()+" mills"); ;
    }
}
