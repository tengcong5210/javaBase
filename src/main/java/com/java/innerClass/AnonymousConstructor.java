package com.java.innerClass;

/**
 * 匿名内部类之构造器
 * 
 * @author linco lee
 */
public class AnonymousConstructor {
    public static Base getBase(int i) {

        return new Base(i) {
            {
                System.out.println("inside instance initialize");
            }

            public void f() {
                System.out.println("in anonamous f()");
            }
        };
    }

    public static void main(String[] args) {
        Base b = getBase(6);
        b.f();
    }
}
