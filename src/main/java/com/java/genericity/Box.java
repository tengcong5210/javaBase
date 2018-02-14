package com.java.genericity;

/**
 * 泛型类
 * @author tengcongcong
 * @create 2018-02-14 13:44
 * @Version 1.0
 **/
public class Box<T> {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
