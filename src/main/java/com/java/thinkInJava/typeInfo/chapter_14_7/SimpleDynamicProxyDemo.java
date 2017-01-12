package com.java.thinkInJava.typeInfo.chapter_14_7;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 类SimpleDynamicProxyDemo.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月21日 下午3:23:53
 * @version 1.0.0
 */
public class SimpleDynamicProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) throws Exception {
        RealObject real = new RealObject();
        //        consumer(real);

        DynamicProxyHandler dph = new DynamicProxyHandler(real);//调用处理程序对象【即实现接口InvocationHandler的类】

        //getProxyClass返回代理类的Class对象，该代理类将由指定的类加载器定义，并将实现提供的所有接口。
        //注意：interfaces数组中Class对象必须表示接口，而不能表示类或基本类型。 Interface 是代理接口
        Class proxyClass = Proxy.getProxyClass(Interface.class.getClassLoader(), new Class[] { Interface.class });
        //
        System.out.println("Proxy构造函数个数:" + proxyClass.getConstructors().length);
        for (Constructor c : proxyClass.getConstructors()) {
            System.out.println("Proxy构造函数名称:" + c.getName());
            System.out.println("构造函数参数类型:" + c.getParameterTypes()[0].getName());
        }
        System.out.println("实现的接口leng:" + proxyClass.getInterfaces().length);
        for (Class clazz : proxyClass.getInterfaces()) {
            System.out.println("Proxy实现的接口:" + clazz.getSimpleName());
        }
        Interface proxy = (Interface) proxyClass.getConstructor(new Class[] { InvocationHandler.class }).newInstance(
                new Object[] { dph });//代理实例【代理类的一个实例】 ，当调用代理实例中的方法时会触发InvacationHandler的invoke方法。为什么会触发invoke方法呢?

        Interface proxy2 = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
                new Class[] { Interface.class }, dph);

        consumer(proxy2);
    }
}
