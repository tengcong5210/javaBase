package com.java.thinkInJava.typeInfo.chapter_14_7;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 类SelectMethods.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月21日 下午9:02:56
 * @version 1.0.0
 */
public class SelectMethods {
    public static void main(String[] args) throws Exception {
        Implementation proxied = new Implementation();
        MethodSelector ms = new MethodSelector(proxied);

        //        SomeMethods proxy1 = (SomeMethods) Proxy.newProxyInstance(SomeMethods.class.getClassLoader(),
        //                new Class[] { SomeMethods.class }, ms);

        Class proxyClazz = Proxy.getProxyClass(SomeMethods.class.getClassLoader(), new Class[] { SomeMethods.class });
        SomeMethods proxy2 = (SomeMethods) proxyClazz.getConstructor(new Class[] { InvocationHandler.class })
                .newInstance(new Object[] { ms });
        proxy2.boring1();
        proxy2.boring2();
        proxy2.interesting("aaaaa");
        proxy2.boring3();
    }
}
