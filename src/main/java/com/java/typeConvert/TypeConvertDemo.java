package com.java.typeConvert;

/**
 * 类型转换
 * 
 * @author linco lee
 */
public class TypeConvertDemo {

    public static void longConvertString() {
        Long l = 100L;
        String s1 = String.valueOf(l);
        String s2 = l + "";

    }

    public static void main(String[] args) {
        longConvertString();
    }

}
