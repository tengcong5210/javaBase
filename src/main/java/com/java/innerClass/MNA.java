package com.java.innerClass;

/**
 * 内部类的多层嵌套：内部类被嵌套多少层不重要，重要的是它能访问所有外部类的成员
 * 
 * @author linco lee
 */
public class MNA {
    private void f() {
        System.out.println("MNA.f()");
    }

    class A {
        private void g() {
            System.out.println("A.g()");
        }

        public class B {
            void h() {
                g();//上级外部类
                f();//上上级外部类
            }
        }
    }

    public static void main(String[] args) {
        MNA mna = new MNA();
        MNA.A a = mna.new A();
        MNA.A.B b = a.new B();
        b.h();
    }
}
