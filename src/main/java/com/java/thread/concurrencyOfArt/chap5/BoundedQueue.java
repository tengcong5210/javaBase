package com.java.thread.concurrencyOfArt.chap5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 有界队列
 * Created by ibm on 2017/8/21.
 */
public class BoundedQueue<T> {
    private Object[] items;
    //添加的下标，删除的下标和数组当前量
    private int addIndex,removeIndex,count;
    private Lock lock=new ReentrantLock();
    private Condition notEmpty=lock.newCondition();
    private Condition notFull=lock.newCondition();

    public BoundedQueue(int size){
        items=new Object[size];
    }
    // 添加一个元素，如果数组满，则添加线程进入等待状态，直到有“空位”
    public void add(T t) throws InterruptedException {
        lock.lock();
        try {
            while (count==items.length){
                    notFull.await();
            }
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
        lock.lock();
        try {
            while (count==0){
                    notEmpty.await();
            }
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