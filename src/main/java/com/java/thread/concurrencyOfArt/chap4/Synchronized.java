package com.java.thread.concurrencyOfArt.chap4;

/**
 * 通过javap -v Synchronized.class看字节码
 * Created by ibm on 2017/4/10.
 */
public class Synchronized {
    public static void main(String[] args){
        //同步块 对Synchronized class对象进行上锁
        synchronized (Synchronized.class){

        }
        //静态同步方法
        m();

    }
    //synchronized方法
    public static synchronized void m(){

    }
}
