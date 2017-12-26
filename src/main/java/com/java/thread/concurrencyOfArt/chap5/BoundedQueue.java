package com.java.thread.concurrencyOfArt.chap5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 有界队列 主要是考察Condition的用法
 *当调用Condition.await方法后,当前线程会释放锁并在此等待
 *当调用condition对象的signal()方法，通知当前线程后，当前线程才从await()返回.并且在返回前获取了锁
 * Created by ibm on 2017/8/21.
 */
public class BoundedQueue<T> {

    private static final Logger LOGGER= LoggerFactory.getLogger(BoundedQueue.class);
    private Object[] items;
    //添加的下标，删除的下标和数组当前量
    private int addIndex,removeIndex,count;

    private Lock lock=new ReentrantLock();
    //移除等待条件
    private Condition notEmpty=lock.newCondition();
    //添加等待条件
    private Condition notFull=lock.newCondition();

    public BoundedQueue(int size){
        items=new Object[size];
    }
    // 添加一个元素，如果数组满，则添加线程进入等待状态，直到有“空位”
    public void add(T t) throws InterruptedException {
        LOGGER.info(Thread.currentThread().getName()+",BoundedQueue.add,count:{}",count);
        lock.lock();
        try {
            while (count==items.length){
                LOGGER.info(Thread.currentThread().getName()+" is await");
                notFull.await();
            }
            LOGGER.info(Thread.currentThread().getName()+" is notify");
            items[addIndex]=1;
            if(++addIndex==items.length){
                addIndex=0;
            }
            ++count;
            notEmpty.signal();
        }finally {
            lock.unlock();
        }

    }
    // 由头部删除一个元素，如果数组空，则删除线程进入等待状态，直到有新添加元素
    public T recome() throws InterruptedException {
        LOGGER.info(Thread.currentThread().getName()+",BoundedQueue.recome,count:{}",count);
        lock.lock();
        try {
            while (count==0){
                LOGGER.info(Thread.currentThread().getName()+",BoundedQueue.recome is await");
                notEmpty.await();
            }
            LOGGER.info(Thread.currentThread().getName()+",BoundedQueue.recome is notify");
            Object x=items[removeIndex];
            if(++removeIndex==items.length){
                removeIndex=0;
            }
            notFull.signal();
            return (T)x;
        }finally {
            lock.unlock();
        }

    }
}
