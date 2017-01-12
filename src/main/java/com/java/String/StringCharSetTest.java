package com.java.String;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringCharSetTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str1 = "648083524111111111648083524222222222648083524333333333648083524";
        String str2 = "648083524";
        String[] strs = str1.split(str2);
        System.out.println(Arrays.toString(strs));
        System.out.println("length:" + strs.length);
    }

}
