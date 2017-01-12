package com.java.oop.abstracts;

public class EmptyAbstractClassSub extends EmptyAbstractClass {
    void test() {
        System.out.println("EmptyAbstractClassSub.test()");
    }

    static void test2(EmptyAbstractClass eac) {
        //        EmptyAbstractClassSub eacs = (EmptyAbstractClassSub) eac;
        //        eac.test();
    }

    public static void main(String[] args) {
        EmptyAbstractClass eac = new EmptyAbstractClassSub();
        test2(eac);
    }
}
