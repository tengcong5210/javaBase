package com.java.designPattern.observer1;

/**
 * @author tengcongcong
 * @create 2018-02-04 19:12
 * @Version 1.0
 **/
public class ConcreteObserver2 implements Observer1 {

    public void update() {
        System.out.println("观察者2收到消息，并进行处理s");
    }
}
