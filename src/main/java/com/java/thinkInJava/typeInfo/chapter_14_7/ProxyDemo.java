package com.java.thinkInJava.typeInfo.chapter_14_7;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 类ProxyDemo.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月21日 下午1:46:37
 * @version 1.0.0
 */
public class ProxyDemo {
    public static void main(String[] args) {

        Class clazz = Proxy.getProxyClass(Interface.class.getClassLoader(), new Class[] { Interface.class });
        System.out.println(clazz.getName());
        for (Method m : clazz.getDeclaredMethods()) {
            System.out.println("method:" + m.getName());
        }
    }
}
