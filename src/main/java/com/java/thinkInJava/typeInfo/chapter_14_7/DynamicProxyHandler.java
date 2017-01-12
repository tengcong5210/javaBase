package com.java.thinkInJava.typeInfo.chapter_14_7;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 类DynamicProxyHandler.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月21日 上午10:31:32
 * @version 1.0.0
 */
public class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----proxy:" + proxy.getClass() + ";method:" + method.getName() + ";args:" + args);
        if (null != args) {
            for (Object arg : args) {
                System.out.println("  " + arg);
            }
        }
        //        Proxy.getInvocationHandler(proxy)Proxy中有InvocationHandler的引用
        return method.invoke(proxied, args);
    }
}
