package com.java.oop.abstracts;

public class Music4 {
    static void tune(Instrument i) {
        i.play();
    }

    static void tuneAll(Instrument[] is) {
        for (Instrument instrument : is) {
            tune(instrument);
        }
    }

    public static void main(String[] args) {
        Instrument[] ins = { new Wind(), new Percussion(), new Stringed(), new Brass(), new Woodwind() };
        tuneAll(ins);
    }

}
