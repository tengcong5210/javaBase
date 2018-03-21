package com.java.designPattern.proxy.cglib;

/**
 * @author tengcongcong
 * @create 2017-09-30 15:52
 * @Version 1.0
 **/
public class TestCglibProxy {

    public static void main(String[] args){

        //JDK的动态代理是通过接口来进行强制转换的
        //生成以后的代理对象，可以强制转换为接口


        //CGLib的动态代理是通过生成一个被代理对象的子类，然后重写父类的方法
        //生成以后的对象，可以强制转换为被代理对象（也就是用自己写的类）
        //子类引用赋值给父类


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
