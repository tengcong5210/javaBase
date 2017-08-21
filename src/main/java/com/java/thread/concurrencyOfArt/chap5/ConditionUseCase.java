package com.java.thread.concurrencyOfArt.chap5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition定义了等待/通知两种类型的方法，当前线程调用这些方法时，
 * 需要提前获取到Condition对象关联的锁。
 * 创建方式:new ReentrantLock().newCondition();即依赖于Lock对象进行创建
 * Created by ibm on 2017/8/21.
 */
public class ConditionUseCase{
    Lock lock=new ReentrantLock();
    //一般condition对象作为成员变量.

    Condition condition=lock.newCondition();

    public void conditionWait() throws InterruptedException {
        lock.lock();
        try {
           //当调用await方法后,当前线程会释放锁并在此等待
            condition.await();
        }finally {
            lock.unlock();
        }
    }

    public void conditionSignal(){
        lock.lock();
        try {
            //当调用condition对象的signal()方法，通知当前线程后，当前线程才从await()返回.
            //并且在返回前获取了锁
            condition.signal();
        }finally {
            lock.unlock();
        }
    }

}
