package com.java.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象目标角色
 * 
 * @author linco lee
 */
public class Subject {
    /**
     * 保存注册观察者的集合
     */
    private List<Observer> observerList = new ArrayList<Observer>();

    /**
     * 注册观察者对象
     * 
     * @param objserver
     */
    public void attach(Observer objserver) {
        observerList.add(objserver);
    }

    /**
     * 删除观察者对象
     * 
     * @param observer
     */
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    /**
     * 通知所有注册观察者对象
     */
    public void notifyObserver() {
        for (Observer observer : observerList) {
            observer.update(this);
        }
    }
}
