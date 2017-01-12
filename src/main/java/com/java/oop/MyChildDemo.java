package com.java.oop;

/**
 * 类MyChildDemo.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年10月28日 上午10:01:45
 * @version 1.0.0
 */
public class MyChildDemo extends MyParentDemo {
    /**
     * 注意：子类showAge方法与父类同名，但返回值不同，不构成重写，也不构成重载，如果子类showAge()方法增加一个参数，
     * 应该和父类的showAge()方法构成重载
     */
    public void showAge(int age) {
        System.out.println("child showAge()");
    }

    public static void main(String[] args) {
        MyChildDemo mcd = new MyChildDemo();
    }
}
