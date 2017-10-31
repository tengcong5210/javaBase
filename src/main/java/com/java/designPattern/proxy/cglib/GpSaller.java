package com.java.designPattern.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author tengcongcong
 * @create 2017-09-30 15:22
 * @Version 1.0
 **/
public class GpSaller implements MethodInterceptor {

    /**
     * 获取代理类
     * @param clazz
     * @return
     */
    public Object getInstance(Class clazz){
        Enhancer enhancer=new Enhancer();
        //把父类设置给谁？
        //告诉cglib,生成的子类需要继承哪个父类
        enhancer.setSuperclass(clazz);
        //设置回调。。回调什么意思？
        enhancer.setCallback(this);
        //step1；生成源代码
        //step2: 编译成Class文件
        //step3: 加载到JVM中，并返回被代理对象
        return enhancer.create();
    }

    /**
     * 该方法时什么时候被调用的呢？猜测：是通过生成的代理类的回调
     * @param o cglib生成的代理类实例，该类是被代理对象的子类（继承自Saller类）。
     * @param method 被代理对象的方法引用
     * @param objects 为参数值列表
     * @param methodProxy 生成的代理类对方法的代理引用
     * @return
     * @throws Throwable
     */
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("给土豆装饰一下，大小分开");
        methodProxy.invokeSuper(o,objects);
        System.out.println("抽走我的提成");
        return null;
    }
}
