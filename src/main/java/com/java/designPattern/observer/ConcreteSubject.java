package com.java.designPattern.observer;

/**
 * 具体抽象角色
 * 
 * @author linco lee
 */
public class ConcreteSubject extends Subject {
    /**
     * 目标对象状态
     */
    private String subjectState;

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
        //状态更新通知各个观察者对象
        this.notifyObserver();
    }

}
