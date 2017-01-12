package com.java.oop.interfaces;

public class MyDowncase extends StringProcessor {

    @Override
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }

}
