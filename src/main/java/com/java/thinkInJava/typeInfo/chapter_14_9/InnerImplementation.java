package com.java.thinkInJava.typeInfo.chapter_14_9;

/**
 * 类InnerImplementation.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月22日 上午11:08:06
 * @version 1.0.0
 */
public class InnerImplementation {
    public static void main(String[] args) throws Exception {
        A a = InnerA.makeA();
        a.f();
        System.out.println("a.getClass().getName():" + a.getClass().getName());
        HiddenImplementation.callHiddenMethod(a, "g");
        HiddenImplementation.callHiddenMethod(a, "u");
        HiddenImplementation.callHiddenMethod(a, "v");
        HiddenImplementation.callHiddenMethod(a, "w");
    }
}

class InnerA {
    //私有内部类
    private static class C implements A {

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

    public static A makeA() {
        return new C();
    }
}
