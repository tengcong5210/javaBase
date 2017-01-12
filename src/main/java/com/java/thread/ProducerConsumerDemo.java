package com.java.thread;

/**
 * 生产者消费者Demo
 * 
 * @author tengcongcong
 * @date 2015年11月29日 上午9:12:38
 * @version 1.0.0
 */
public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Resources rs = new Resources();
        Producer pro = new Producer(rs);
        Consumer con = new Consumer(rs);

        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(pro);
        Thread t3 = new Thread(con);
        Thread t4 = new Thread(con);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class Resources {
    private String  name;
    private int     count = 1;
    private boolean flag  = false;

    public synchronized void set(String name) {
        while (flag) { //将if 改成while
            try {
                wait();
            } catch (Exception e) {

            }
        }
        this.name = name + ":" + count++;
        System.out.println(Thread.currentThread().getName() + "...生产者..." + this.name);
        flag = true;
        this.notifyAll();

    }

    public synchronized void out() {
        while (!flag) {
            try {
                wait();
            } catch (Exception e) {

            }
        }
        System.out.println(Thread.currentThread().getName() + "......消费者......" + this.name);
        flag = false;
        this.notifyAll();

    }
}

//生产者
class Producer implements Runnable {
    private Resources r;

    public Producer(Resources r) {
        this.r = r;
    }

    public void run() {
        while (true) {
            r.set("--苹果--");
        }
    }
}

//消费者
class Consumer implements Runnable {
    private Resources r;

    public Consumer(Resources r) {
        this.r = r;
    }

    public void run() {
        while (true) {
            r.out();
        }

    }
}
