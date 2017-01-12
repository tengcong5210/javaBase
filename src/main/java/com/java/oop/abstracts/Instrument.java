package com.java.oop.abstracts;

/**
 * 乐器
 * 
 * @author tengcongcong
 */
public abstract class Instrument {

    abstract void play();

    String what() {
        return "instrument";
    }

    abstract void adjust();
}
