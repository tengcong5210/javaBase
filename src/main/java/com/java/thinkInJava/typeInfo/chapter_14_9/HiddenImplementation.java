package com.java.thinkInJava.typeInfo.chapter_14_9;

import java.lang.reflect.Method;

import com.java.thinkInJava.typeInfo.chapter_14_9.packageaccess.HiddenC;

/**
 * 类HiddenImplementation.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月22日 上午10:34:52
 * @version 1.0.0
 */
public class HiddenImplementation {
    public static void main(String[] args) throws Exception {
        A a = HiddenC.makeA();
        a.f();
        System.out.println("a.getClass().getName()" + a.getClass().getName());
        //        if(a instanceof C){  compile error
        //            C c=(C)a;
        //            c.g();
        //        }
        callHiddenMethod(a, "g");
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }

    static void callHiddenMethod(A a, String methodName) throws Exception {
        Method m = a.getClass().getDeclaredMethod(methodName);
        m.setAccessible(true);
        m.invoke(a);
    }
}
