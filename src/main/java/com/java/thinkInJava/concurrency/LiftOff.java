package com.java.thinkInJava.concurrency;

/**
 * 火箭发射
 * 
 * @author tengcongcong
 * @date 2016年1月31日 下午9:17:52
 * @version 1.0.0
 */
public class LiftOff implements Runnable {
    protected int      countDown = 10;         //default
    private static int taskCount = 0;          //taskCount是static的  即类变量.
    private final int  id        = taskCount++; //++在后 表示先将taskCount(0)赋值给id，然后再将taskCount+1. id 是final 必须初始化赋值或是在构造中赋值

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "liftoff!") + "), ";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            Thread.yield();//暂停当前正在执行的线程对象，并执行其他线程。
        }
    }

}
