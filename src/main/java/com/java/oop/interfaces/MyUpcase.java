package com.java.oop.interfaces;

public class MyUpcase extends StringProcessor {

    @Override
    public String process(Object input) {
        return ((String) input).toUpperCase();
    }

}
