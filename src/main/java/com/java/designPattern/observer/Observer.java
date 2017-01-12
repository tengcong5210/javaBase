package com.java.designPattern.observer;

/**
 * 抽象观察者角色
 * 
 * @author linco lee
 */
public interface Observer {
    /**
     * 被通知的方法
     * 
     * @param subject
     */
    public void update(Subject subject);
}
