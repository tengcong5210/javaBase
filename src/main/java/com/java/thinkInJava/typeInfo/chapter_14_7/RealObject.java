package com.java.thinkInJava.typeInfo.chapter_14_7;

/**
 * 真实对象
 * 
 * @author tengcongcong
 * @date 2015年11月21日 上午8:10:25
 * @version 1.0.0
 */
public class RealObject implements Interface {
    public void doSomething() {
        System.out.println("doSomething");
    }

    public void somethingElse(String arg) {
        System.out.println("somethingElse:" + arg);
    }
}
