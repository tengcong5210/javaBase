package com.java.oop.abstracts;

public class Stringed extends Instrument {

    @Override
    void play() {
        System.out.println("Stringed play()");

    }

    @Override
    void adjust() {
        // TODO Auto-generated method stub

    }

    String what() {
        return "Stringed";
    }
}
