package com.java.thinkInJava.concurrency;

/**
 * 类MainThread.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2016年1月31日 下午9:40:48
 * @version 1.0.0
 */
public class MainThread {
    public static void main(String[] args) {
        //1.
        //        LiftOff launch = new LiftOff();
        //        launch.run();

        //2.basicThreads
        //        Thread t = new Thread(new LiftOff());
        //        t.start();
        //        System.out.println("Waiting for LiftOff");

        //3.moreThread
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
            System.out.println("Waiting for LiftOff");
        }
    }
}
