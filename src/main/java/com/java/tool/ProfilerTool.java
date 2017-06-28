package com.java.tool;

import com.java.thread.concurrencyOfArt.chap4.Profiler;

import java.util.concurrent.TimeUnit;

/**
 * 该类通过ThreadLocal类计算业务方法的耗时，
 * Created by ibm on 2017/5/30.
 */
public class ProfilerTool {

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

    public static void main(String[] args) throws InterruptedException {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Cost:"+Profiler.end()+" mills"); ;
    }
}
