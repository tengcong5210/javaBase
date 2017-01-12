package com.java.thinkInJava.typeInfo.chapter_14_9;

/**
 * 类B.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月22日 上午10:16:01
 * @version 1.0.0
 */
public class B implements A {
    public void f() {
        System.out.println("b.f()");
    }

    public void g() {
        System.out.println("b.g()");
    }

    public static void main(String[] args) {
        A b = new B();
        System.out.println("name:" + b.getClass().getName());
        b.f();
        //        b.g();
        if (b instanceof B) {
            B bb = (B) b;
            bb.g();
        }
    }
}
