package com.java.thread.concurrencyOfArt.chap3;

/**
 * 双重检查锁(不安全的，要实现安全的请参照SafeDoubleCheckedLocking)
 * Created by ibm on 2017/4/3.
 */
public class DoubleCheckedLocking {//1
    private static Instance instance;//2
    //当线程执行到第4行，代码读取到instance不为null时，instance引用的对象有可能还没有完成初始化
    //具体原因在第7行会引起重排序。当new Instance()执行时，具体含义如下：
    //a.分配对象的内存空间
    //b.初始化对象
    //c.将对象赋值给该对象的引用
    //重排序后变成 a、c、b。如果发生重排序，另一个并发线程执行的线程B有可能在第4行判断instance不为null,
    //接着线程B将访问instance对象的引用。但此时这个对象可能还没有被A线程初始化
    public static Instance getInstance(){//3
        if(instance==null){//4:第一次检查
            synchronized (DoubleCheckedLocking.class){//5:加锁
                if(instance==null){//6:第二次检查
                    instance=new Instance();//7：问题根源出在这
                }//8
            }//9
        }
        return instance;//10
    }
    static class Instance{

    }
}
