package com.java.thinkInJava.typeInfo.chapter_14_7;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 类MethodSelector.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月21日 下午8:46:35
 * @version 1.0.0
 */
public class MethodSelector implements InvocationHandler {
    private Object proxied;

    public MethodSelector(Object proxied) {
        this.proxied = proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理对象:" + proxy.getClass().getSimpleName());
        System.out.println("代理对象实现的接口:" + proxy.getClass().getInterfaces()[0].getName());
        System.out.println("方法名:" + method.getName());
        return method.invoke(proxied, args);
    }
}
