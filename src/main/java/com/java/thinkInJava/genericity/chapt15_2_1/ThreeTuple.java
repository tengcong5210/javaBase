package com.java.thinkInJava.genericity.chapt15_2_1;

/**
 * 类ThreeTuple.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月29日 下午9:09:10
 * @version 1.0.0
 */
public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
    public final C third;

    public ThreeTuple(A a, B b, C c) {
        super(a, b);
        this.third = c;
    }

    public String toString() {
        return "(" + first + "," + second + "," + third + ")";
    }

    public static void main(String[] args) {
        System.out.println(new ThreeTuple<String, String, Integer>("张三", "男", 15));
    }
}
