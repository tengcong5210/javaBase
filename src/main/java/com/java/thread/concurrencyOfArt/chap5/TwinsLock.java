package com.java.thread.concurrencyOfArt.chap5;



import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 自定义同步组件：共享锁
 * 该组件在同一时刻，只允许至多两个线程同时访问，超过两个线程的访问将被阻塞。
 * Created by ibm on 2017/4/25.
 */
public class TwinsLock implements Lock{

    private final Sync sync=new Sync(2);
    private static final class Sync extends AbstractQueuedSynchronizer{

        Sync(int count){
            if(count<=0){
                throw new IllegalArgumentException("count must large than zero.");
            }
            setState(count);
        }

        @Override
        protected int tryAcquireShared(int reduceCount) {
            for(;;){
                int current=getState();
                int newCount=current-reduceCount;
                if(newCount<0||compareAndSetState(current,newCount)){
                    return newCount;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int returnCount) {
           for(;;){
               int current=getState();
               int newCount=current+returnCount;
               if(compareAndSetState(current,newCount)){
                   return true;
               }
           }
        }
    }

    public void lock() {
        sync.acquireShared(1);
    }

    public void lockInterruptibly() throws InterruptedException {

    }

    public boolean tryLock() {
        return false;
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    public void unlock() {
        sync.releaseShared(1);
    }

    public Condition newCondition() {
        return null;
    }
}
