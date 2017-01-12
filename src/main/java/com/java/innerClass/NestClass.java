package com.java.innerClass;

import java.util.List;

/**
 * 嵌套类：将内部类声明为static，该类就变为嵌套类了
 * 
 * @author linco lee
 */
public class NestClass {
    public static <T> List<T> asList(T... a) {

        return (List<T>) new MyArraylist();
    }

    private static class MyArraylist<E> {

    }
}
