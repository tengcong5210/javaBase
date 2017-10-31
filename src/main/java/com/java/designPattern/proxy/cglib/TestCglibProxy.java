package com.java.designPattern.proxy.cglib;

/**
 * @author tengcongcong
 * @create 2017-09-30 15:52
 * @Version 1.0
 **/
public class TestCglibProxy {

    public static void main(String[] args){

       //一、通过cglib代理和Jdk的代理类有啥异同？
       //答：cglib代理不需要代理类实现接口，是通过生成代理类的子类（通过ASM字节码生成，比反射效率高）
        //   而JDK动态代理只能为实现某接口的类进行代理，有局限性。
        //   唯一需要注意的是cglib代理不能对final方法、或是final修饰的类进行代理。因为cglib原理是动态生成代理类的子类

        GpSaller gpSaller=new GpSaller();
        //生成一个代理类  即（代理类obj是 Saller 的子类）
        Saller obj=(Saller)gpSaller.getInstance(Saller.class);
        System.out.println("代理类："+obj.getClass().getName());
        obj.sale();

    }
}
