package com.java.designPattern.observer1;

/**
 * @author tengcongcong
 * @create 2018-02-04 19:30
 * @Version 1.0
 **/
public class ObserverClient {

    public static void main(String[] args){
        Subject1 subject1=new ConcreteSubject1();
        subject1.addObserver1(new ConcreteObserver1());
        subject1.addObserver1(new ConcreteObserver2());
        subject1.doSomething();
    }
}
