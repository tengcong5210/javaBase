package com.java.designPattern.observer;

/**
 * 具体观察者对象
 * 
 * @author linco lee
 */
public class ConcreteObserver implements Observer {

    private String observerName;

    public String getObserverName() {
        return observerName;
    }

    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }

    public void update(Subject subject) {
        System.out.println(observerName + "状态变更了：" + ((ConcreteSubject) subject).getSubjectState());
    }

}
