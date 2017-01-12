package com.java.thinkInJava.genericity.chapt_15_4;

/**
 * 泛型方法
 * 
 * @author tengcongcong
 * @date 2015年11月30日 上午7:02:39
 * @version 1.0.0
 */
public class GenericMethods {
    public <T, K> void f(T x, K k, Boolean v) {
        System.out.println(x.getClass().getSimpleName() + "," + k.getClass().getSimpleName() + ","
                + v.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("", "", false);
        gm.f(1, 1.0, false);
    }
}
