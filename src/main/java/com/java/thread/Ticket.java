package com.java.thread;

/**
 * 类Ticket.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月28日 上午8:40:22
 * @version 1.0.0
 */
public class Ticket implements Runnable {

    private Integer count = 1000;

    private Object  obj   = new Object();

    public boolean  flag  = true;

    public void run() {

        if (flag) {
            while (true) {
                /**
                 * synchronized(obj) this .class
                 */
                synchronized (obj) {
                    System.out.println("run----");
                    //                    if (count > 0) {
                    //                        System.out.println("run----");
                    //                        try {
                    //                            Thread.sleep(10);
                    //                        } catch (Exception e) {
                    //                        }
                    //                        System.out.println(Thread.currentThread().getName() + ".....count=" + count--);
                    //                    }
                    show();
                }

            }
        } else {
            while (true) {
                show();
            }
        }

    }

    /**
     * 注意synchronized 方法 所对象是this
     */
    public synchronized void show() {
        synchronized (obj) {
            System.out.println("+++++++++++++++++++++show()");
            if (count > 0) {
                System.out.println("run----");
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                }
                System.out.println(Thread.currentThread().getName() + ".....count=" + count--);
            }
        }

    }
}
