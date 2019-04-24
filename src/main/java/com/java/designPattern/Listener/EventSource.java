package com.java.designPattern.Listener;

/**
 * 事件源
 */
public class EventSource implements IEvent {
    private IEventListener listener;
    public EventSource(){

    }
    public EventSource(IEventListener listener){
        this.listener=listener;
    }
    public void mouseClick() {
        System.out.println("触发鼠标单击事件");
        listener.doEvent(this);
    }

    public void mouseMove() {
        System.out.println("触发鼠标移动事件");
        listener.doEvent(this);
    }
}
