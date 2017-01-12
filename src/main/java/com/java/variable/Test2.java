package com.java.variable;

public class Test2 {

    public void print() {
        System.out.println(Test2.class);
        System.out.println(this.getClass());
        System.out.println(Test2.class.getClassLoader());
    }

}
