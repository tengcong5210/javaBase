package com.java.oop.abstracts;

/**
 * 该类继承自抽象类
 * 
 * @author linco lee
 */
public class AbstractClassConstructChild extends AbstractClassConstructBase {
    public AbstractClassConstructChild() {
        System.out.println("子类构造器");
    }

    public static void main(String[] args) {
        AbstractClassConstructChild accc = new AbstractClassConstructChild();
        // AbstractClassConstructBase accb = new AbstractClassConstructBase();
    }
}
