package com.java.abstractT;

/**
 * 抽象类
 * 
 * @author linco lee
 */
public abstract class OpenAbstractTest implements OpenInterfaceTest {
    /**
     * 抽象类可以有构造方法
     */
    public OpenAbstractTest() {
        System.out.println("抽象类构造方法");
    }

    public abstract void eat();

    public void play() {
        System.out.println("打篮球");
    }

    @Override
    public void say() {
        System.out.println("hello word");
    }

    @Override
    public void run() {
        System.out.println("跑步");
    }

    @Override
    public void move() {
        System.out.println("移动");

    }

}
