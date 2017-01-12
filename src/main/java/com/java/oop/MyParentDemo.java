package com.java.oop;

/**
 * 类MyParentDemo.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年10月28日 上午9:55:10
 * @version 1.0.0
 */
public class MyParentDemo {
    private String name = "张三"; //私有属性不能被子类继承

    /**
     * 私有方法不能被覆盖
     */
    private void show() {
        System.out.println("my name is " + name);
    }

    public int showAge() {
        System.out.println("I'm 3 year");
        return 3;
    }

}
