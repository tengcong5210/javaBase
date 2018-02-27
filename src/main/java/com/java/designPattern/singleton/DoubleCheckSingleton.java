package com.java.designPattern.singleton;

/**
 * 文章来源：
 * https://mp.weixin.qq.com/s?__biz=MzUzMTA2NTU2Ng==&mid=2247483793&idx=1&sn=40ffc5ed384b6d7beacf87a44e30c8c3&chksm=fa497e20cd3ef736ae174e9a9698e5d4ff04dbfe68dc56c636584dcbd4952242ecc4476b8956&mpshare=1&scene=1&srcid=0209kVxwKTkkRJvZOJ6Vg54T#rd
 * 双重检查单例
 * @author tengcongcong
 * @create 2018-02-27 15:57
 * @Version 1.0
 **/
public class DoubleCheckSingleton {

    private static DoubleCheckSingleton singleton=null;
    //当singleton声明为volatile后，步骤2、步骤3就不会被重排序了，也就可以解决上面那问题了。
    //private volatile static DoubleCheckSingleton singleton=null;

    private DoubleCheckSingleton(){}
    /*就如上面所示，这个代码看起来很完美，理由如下：

    如果检查第一个singleton不为null,则不需要执行下面的加锁动作，极大提高了程序的性能；
    如果第一个singleton为null,即使有多个线程同一时间判断，但是由于synchronized的存在，只会有一个线程能够创建对象；
    当第一个获取锁的线程创建完成后singleton对象后，其他的在第二次判断singleton一定不会为null，则直接返回已经创建好的singleton对象；
    通过上面的分析，DCL看起确实是非常完美，但是可以明确地告诉你，这个错误的。上面的逻辑确实是没有问题，分析也对，但是就是有问题，那么问题出在哪里呢？在回答这个问题之前，我们先来复习一下创建对象过程，实例化一个对象要分为三个步骤：

    分配内存空间
            初始化对象
    将内存空间的地址赋值给对应的引用
    但是由于重排序的缘故，步骤2、3可能会发生重排序，其过程如下：

    分配内存空间
            将内存空间的地址赋值给对应的引用
    初始化对象
    如果2、3发生了重排序就会导致第二个判断会出错，singleton != null，但是它其实仅仅只是一个地址而已，此时对象还没有被初始化，所以return的singleton对象是一个没有被初始化的对象*/
    public static DoubleCheckSingleton getInstance(){

        if(singleton==null){//1

            synchronized (DoubleCheckSingleton.class){//2

                if(singleton==null){//3

                    singleton=new DoubleCheckSingleton(); //4
                }
            }
        }
        return singleton;
    }

}
