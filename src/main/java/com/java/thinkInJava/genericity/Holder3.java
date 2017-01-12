package com.java.thinkInJava.genericity;

/**
 * 类Holder3.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月23日 上午8:11:10
 * @version 1.0.0
 */
public class Holder3<T> {
    private T a;

    public Holder3(T a) {
        this.a = a;
    }

    public void set(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }

    public static void main(String[] args) {
        Holder3<Automobile> h3 = new Holder3<Automobile>(new Automobile());
        Automobile a = h3.get();
    }
}
