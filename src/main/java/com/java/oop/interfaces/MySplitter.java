package com.java.oop.interfaces;

import java.util.Arrays;

public class MySplitter extends StringProcessor {

    @Override
    public String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }

}
