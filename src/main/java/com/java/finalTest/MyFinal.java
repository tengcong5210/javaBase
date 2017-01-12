package com.java.finalTest;

import java.util.Arrays;
import java.util.Random;

/**
 * 关于final关键字测试
 * 
 * @author linco lee
 */
public class MyFinal {
    private static Random rand = new Random(47);
    private String        id;

    public MyFinal(String id) {
        this.id = id;
    }

    //can be compile-time constants
    private final int          valueOne    = 9;
    private static final int   VALUE_TWO   = 99;
    //typical public constants
    public static final int    VALUE_THREE = 39;
    //connot be complie-time constants
    private final int          i4          = rand.nextInt(11);
    static final int           INT_5       = rand.nextInt(20);
    //Object 
    private Value              v1          = new Value(11);
    private final Value        v2          = new Value(22);
    private static final Value V_3         = new Value(33);
    private final int[]        a           = { 1, 2, 3, 4, 5, 6 };

    @Override
    public String toString() {
        return "MyFinal [id=" + id + ", valueOne=" + valueOne + ", i4=" + i4 + ", v1=" + v1 + ", v2=" + v2 + ", a="
                + Arrays.toString(a) + "]";
    }

    public static void main(String[] args) {
        MyFinal mf1 = new MyFinal("mf1");
        //        mf1.valueOne++; //error con't change value
        mf1.v2.i++;
        mf1.v1 = new Value(9);
        for (int i = 0; i < mf1.a.length; i++) {
            mf1.a[i]++;
        }
        //mf1.v2 = new Value(0);//error con't change value
        //        mf1.V_3 = new Value(1);
        //        mf1.a = new int[3];
        MyFinal mf2 = new MyFinal("mf2");
    }
}

class Value {
    int         i;
    private int ii = 0;

    public Value(int i) {
        this.i = i;
    }

    private void f() {
        System.out.println("value f method");
    }

    public void g() {
        System.out.println("value g method");
    }
}

class FinalArguments {
    void with(final Value value) {
        //value = new Value(2); //conn't  -- value is final
    }

    void with2(Value value) {
        value = new Value(2); // ok  -- value not final
    }

    void f(final int i) {
        //        i++; //i is finall
    }

    int g(final int i) {
        return i + 1;
    }
}
