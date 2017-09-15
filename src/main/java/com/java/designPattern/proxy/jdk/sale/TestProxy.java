package com.java.designPattern.proxy.jdk.sale;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author tengcongcong
 * @create 2017-09-15 15:36
 * @Version 1.0
 **/
public class TestProxy {

    public static void main(String[]args){
        //被代理对象，即真实对象
        ProducerSale realObj=new ProducerSale();
        //代理处理器，要拥有代理对象的引用
        InvocationHandler handler=new Seller(realObj);
        //生成代理类
        Sale proxyClass=(Sale)Proxy.newProxyInstance(realObj.getClass().getClassLoader(),realObj.getClass().getInterfaces(),handler);

        proxyClass.sale();

    }
}
