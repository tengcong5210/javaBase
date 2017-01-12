package com.java.designPattern.observer;

public class ObserverTest {

    public static void main(String[] args) {
        //创建一个目标对象
        ConcreteSubject conSub = new ConcreteSubject();

        //创建三个观察者对象
        ConcreteObserver conObs1 = new ConcreteObserver();
        conObs1.setObserverName("观察者一");
        ConcreteObserver conObs2 = new ConcreteObserver();
        conObs2.setObserverName("观察者二");
        ConcreteObserver conObs3 = new ConcreteObserver();
        conObs3.setObserverName("观察者三");

        //将三个观察者对象注册到目标对象中去
        conSub.attach(conObs1);
        conSub.attach(conObs2);
        conSub.attach(conObs3);

        //目标状态变更
        conSub.setSubjectState("目标状态变更啦");

        conSub.detach(conObs1);

        conSub.setSubjectState("观察者一取消订阅");

    }

}
