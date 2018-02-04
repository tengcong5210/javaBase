package com.java.designPattern.observer1;

/**
 * @author tengcongcong
 * @create 2018-02-04 19:28
 * @Version 1.0
 **/
public class ConcreteSubject1 extends Subject1 {

    public void doSomething() {
        System.out.println("被观察者事件发生");
        this.notifyObserver1();
    }
}
