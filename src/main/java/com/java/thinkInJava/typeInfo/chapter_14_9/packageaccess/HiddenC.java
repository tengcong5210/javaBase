package com.java.thinkInJava.typeInfo.chapter_14_9.packageaccess;

import com.java.thinkInJava.typeInfo.chapter_14_9.A;

/**
 * 类HiddenC.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月22日 上午10:29:31
 * @version 1.0.0
 */
public class HiddenC {
    public static A makeA() {
        return new C();
    }
}

class C implements A {
    public void f() {
        System.out.println("public C.f()");
    }

    public void g() {
        System.out.println("public C.g()");
    }

    void u() {
        System.out.println("package C.u()");
    }

    protected void v() {
        System.out.println("protected C.v()");
    }

    private void w() {
        System.out.println("private C.w()");
    }
}
