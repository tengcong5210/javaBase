package com.java.thinkInJava.genericity.chapt15_2_1;

/**
 * 类FourTuple.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月29日 下午9:14:58
 * @version 1.0.0
 */
public class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {
    public final D fourth;

    public FourTuple(A a, B b, C c, D d) {
        super(a, b, c);
        fourth = d;
    }

    public String toString() {
        return "(" + first + "," + second + "," + third + "," + fourth + ")";
    }

    public static void main(String[] args) {
        System.out.println(new FourTuple<Integer, Boolean, String, Double>(15, true, "hello word", 2.2));
    }
}
