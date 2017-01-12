package com.java.oop.interfaces;

public class MyApply {
    public static void process(MyProcessor p, Object s) {
        System.out.println("Useing process " + p.name());
        System.out.println(p.process(s));
    }
}
