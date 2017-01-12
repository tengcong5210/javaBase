package com.java.thread;

/**
 * 类DeadLockDemo.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月28日 上午8:47:33
 * @version 1.0.0
 */
public class DeadLockDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread(new DeadLock(true));
        Thread t2 = new Thread(new DeadLock(false));
        t1.start();
        t2.start();
    }
}

/**
 * 锁对象
 * 
 * @author tengcongcong
 * @date 2015年11月28日 上午9:46:53
 * @version 1.0.0
 */
class MyLock {
    static Object lockA = new Object();
    static Object lockB = new Object();
}

/**
 * 死锁线程
 * 
 * @author tengcongcong
 * @date 2015年11月28日 上午9:47:08
 * @version 1.0.0
 */
class DeadLock implements Runnable {

    private boolean flag;

    public DeadLock(boolean flag) {
        this.flag = flag;
    }

    public void run() {
        if (flag) {
            while (true) {
                synchronized (MyLock.lockA) {
                    System.out.println("if locka");
                    synchronized (MyLock.lockB) {
                        System.out.println("if lockb");
                    }
                }
            }

        } else {
            while (true) {
                synchronized (MyLock.lockB) {
                    System.out.println("else lockb");
                    synchronized (MyLock.lockA) {
                        System.out.println("else locka");
                    }
                }
            }

        }
    }
}
