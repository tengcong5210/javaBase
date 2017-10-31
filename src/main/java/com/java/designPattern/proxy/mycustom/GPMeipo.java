package com.java.designPattern.proxy.mycustom;

import com.java.designPattern.proxy.jdk.findlove.Persion;

import java.lang.reflect.Method;

/**
 * @author tengcongcong
 * @create 2017-09-30 16:49
 * @Version 1.0
 **/
public class GPMeipo implements GPInvocationHandler {

    private Persion target;

    public Object getInstance(Persion target)throws Exception{
        this.target=target;
        Class clazz=target.getClass();
        System.out.println("被代理对象的class是:"+clazz);
        return GPPorxy.newProxyInstance(new GPClassLoader(),clazz.getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是媒婆。。巴拉巴拉");
        System.out.println("-----------");

        method.invoke(this.target,args);

        System.out.println("-----------");
        System.out.println("找到合适的，办事");
        return null;
    }
}
