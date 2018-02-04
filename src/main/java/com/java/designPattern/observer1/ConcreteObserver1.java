package com.java.designPattern.observer1;

/**
 * 具体抽象角色
 * @author tengcongcong
 * @create 2018-02-04 19:01
 * @Version 1.0
 **/
public class ConcreteObserver1 implements Observer1 {

    public void update() {
        System.out.println("观察者1收到消息，并进行处理s");
    }
}
