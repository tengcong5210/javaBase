package com.java.thinkInJava.typeInfo.chapter_14_7;

/**
 * 简单代理类
 * 
 * @author tengcongcong
 * @date 2015年11月21日 上午8:14:34
 * @version 1.0.0
 */
public class SimpleProxy implements Interface {
    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    public void doSomething() {
        System.out.println("proxy doSomething");
        proxied.doSomething();
    }

    public void somethingElse(String arg) {
        System.out.println("proxy somethingElse:" + arg);
        proxied.somethingElse("simleProxy");
    }
}
