package com.java.thread.concurrencyOfArt.chap3;

/**
 * 线程安全双重检查锁
 * Created by ibm on 2017/4/3.
 */
public class SafeDoubleCheckedLocking {
    private volatile static Instance instance;

    public static Instance getInstance(){
        if(instance==null){
            synchronized(SafeDoubleCheckedLocking.class){
                if(instance==null){
                    instance=new Instance();//instacne为volatile。使用volatile后之前的重排序会被禁止
                }
            }
        }
        return instance;
    }

    static class Instance{

    }
}
