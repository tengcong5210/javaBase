package com.java.thread.concurrencyOfArt.chap3;

/**
 * 非线程安全的延迟初始化对象
 * Created by ibm on 2017/4/3.
 */
public class UnsafeLazyInitialization {
    private static Instance instance;
    //该方法在多线程的情况下是不安全的。
    //当线程A执行代码1的同时，线程B执行代码2，
    //为了避免这种问题，可以在该方法上加synchronized(见getInstance2).但这样会性能消耗比较严重
    public static Instance getInstance(){
        if(instance==null){//1.A线程执行
            instance=new Instance();//2.B线程执行
        }
        return instance;
    }
    public synchronized static Instance getInstance2(){
        if(instance==null){//1.A线程执行
            instance=new Instance();//2.B线程执行
        }
        return instance;
    }
    static class Instance{

    }
}
