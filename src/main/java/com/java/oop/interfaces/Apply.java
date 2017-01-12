package com.java.oop.interfaces;

public class Apply {
    /**
     * 处理方法：创建一个能够根据所传递的参数的不同而具有不同行为的方法，被称为策略设计模式
     * 
     * @param p
     * @param s
     */
    public static void process(Processor p, Object s) {
        System.out.println("using Processor " + p.name());
        System.out.println(p.process(s));
    }

    public static String s = "I want to go to beijing";

    public static void main(String[] args) {
        process(new Upcase(), s);
        process(new Downcase(), s);
        process(new Splitter(), s);
    }
}
