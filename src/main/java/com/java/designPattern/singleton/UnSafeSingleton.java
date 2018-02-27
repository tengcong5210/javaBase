package com.java.designPattern.singleton;

/**
 * 非线程安全的单例
 * @author tengcongcong
 * @create 2018-02-27 15:42
 * @Version 1.0
 **/
public class UnSafeSingleton {

    private static UnSafeSingleton singleton;

    private UnSafeSingleton(){}

    /**
     * 要想线程安全在方法上 增加synchronized关键字，但影响性能
     * @return
     */
    /*public static synchronized UnSafeSingleton getInstance(){*/
    public static UnSafeSingleton getInstance(){
        if(singleton==null){
            singleton=new UnSafeSingleton();
        }
        return singleton;
    }
}
