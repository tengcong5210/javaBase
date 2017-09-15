package com.java.designPattern.proxy.jdk.sale;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 销售员(即代理角色)
 * @author tengcongcong
 * @create 2017-09-15 14:35
 * @Version 1.0
 **/
public class Seller implements InvocationHandler{
    //持有被代理对象的引用
    private Object target;

    public Seller(Object obj){
        this.target=obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在代理真实对象前我们可以添加一些自己的操作
        System.out.println("before do someing");
        System.out.println("Method:" + method.getName());
        //当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用.
        method.invoke(target,args);
         //在代理真实对象后我们也可以添加一些自己的操作
        System.out.println("after do someing");
        return null;
    }
}
