package com.java.designPattern.observer1;

import org.apache.commons.collections.CollectionUtils;

import java.util.Vector;

/**
 * 被观察者角色
 * @author tengcongcong
 * @create 2018-02-04 19:13
 * @Version 1.0
 **/
public abstract class Subject1 {
    //存储观察者对象容器
    private Vector<Observer1> observer1s=new Vector<Observer1>();

    /**
     *  像容器中添加观察者对象
     * @param obs1
     */
    public void addObserver1(Observer1 obs1){
        this.observer1s.add(obs1);
    }

    /**
     * 从容器中删除观察者对象
     * @param obs1
     */
    public void delObserver1(Observer1 obs1){
        this.observer1s.remove(obs1);
    }

    /**
     * 变更后通知观察者
     */
    protected  void notifyObserver1(){
        if(!CollectionUtils.isEmpty(observer1s)){
            for(Observer1 obs1:observer1s){
                obs1.update();
            }
        }
    }

    public abstract void doSomething();


}
