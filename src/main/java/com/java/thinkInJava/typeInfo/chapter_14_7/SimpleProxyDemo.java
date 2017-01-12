package com.java.thinkInJava.typeInfo.chapter_14_7;

/**
 * 类SimpleProxyDemo.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月21日 上午8:20:43
 * @version 1.0.0
 */
public class SimpleProxyDemo {
    public static void customer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bobo");
    }

    public static void main(String[] args) {
        RealObject realObj = new RealObject();
        customer(realObj);
        SimpleProxy sproxy = new SimpleProxy(realObj);
        customer(sproxy);
    }
}
