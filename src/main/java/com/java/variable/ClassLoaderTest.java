package com.java.variable;

public class ClassLoaderTest {

    public static void main(String[] args) {
        ClassLoader cl = ClassLoaderTest.class.getClassLoader();
        System.out.println("==A:" + cl);
        ClassLoader clParent = cl.getParent();
        System.out.println("==B:" + clParent);
        ClassLoader clRoot = clParent.getParent();
        System.out.println("==C:" + clRoot);
    }

}
