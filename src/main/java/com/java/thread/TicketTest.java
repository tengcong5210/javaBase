package com.java.thread;

public class TicketTest {
    public static void main(String[] args) throws Exception {
        Ticket t = new Ticket();
        Thread thread1 = new Thread(t);
        Thread thread2 = new Thread(t);
        thread1.start();
        Thread.sleep(10);
        t.flag = false;
        thread2.start();

    }
}
