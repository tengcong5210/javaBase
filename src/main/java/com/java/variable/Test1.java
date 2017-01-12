package com.java.variable;

/**
 * @author linco lee
 */
public class Test1 {

    public static void main(String[] args) {
        System.out.println(Test1.class.getClassLoader());
        System.out.println("-------------------");
        Test2 test2 = new Test2();
        test2.print();
    }

}
