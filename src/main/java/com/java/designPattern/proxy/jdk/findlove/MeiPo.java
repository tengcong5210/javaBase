package com.java.designPattern.proxy.jdk.findlove;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 媒婆：即代理角色
 * @author tengcongcong
 * @create 2017-09-14 18:17
 * @Version 1.0
 **/
public class MeiPo implements InvocationHandler {
    //持有被代理的信息
    private Persion target;

    /**
     * 获取代理对象
     * @param target
     * @return
     * @throws Exception
     */
    public Object getInstance(Persion target)throws Exception{
        this.target=target;
        Class clazz=target.getClass();
        System.out.println("被代理对象的class是："+clazz);
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);

        /*public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) throws IllegalArgumentException
        loader:一个ClassLoader对象，定义了由哪个ClassLoader对象来对生成的代理对象进行加载
        interfaces:一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了
        h:一个InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上*/
    }

    /**
     *
     * @param proxy 指代我们所代理的那个真实对象
     * @param method 指代的是我们所要调用真实对象的某个方法的Method对象
     * @param args 指代的是调用真实对象某个方法时接受的参数
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是媒婆：给你找个异性");
        System.out.println("开始进行海选");
        System.out.println("-----------------");
        method.invoke(this.target,args);
        System.out.println("-----------------");
        System.out.println("合适的话，就准备婚事！");
        return null;
    }
}
