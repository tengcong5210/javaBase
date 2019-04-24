package com.java.designPattern.Listener;

public class ListenerTest {

    public static void main(String[] args) throws InterruptedException {
        EventSource click=new EventSource(new IEventListener(){

            public void doEvent(IEvent event) {
                event.mouseClick();
            }
        });
        Thread.sleep(100);
        click.mouseClick();
    }
}
