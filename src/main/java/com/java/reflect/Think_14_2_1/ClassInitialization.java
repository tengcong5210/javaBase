package com.java.reflect.Think_14_2_1;

import java.util.Random;

/**
 * think in java 【14章】 类型信息 【14.2.1】[类字面量常量]
 * 
 * @author tengcongcong
 * @date 2015年11月8日 下午10:00:35
 * @version 1.0.0
 */
public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        Class initable = Initable.class;//仅使用.class语法获得类的引用不会引发初始化。但使用Class.forName()则不同，会立即进行初始化操作。Initable3就是见证
        System.out.println("After creating Initable ref");
        //不会触发初始化
        System.out.println(Initable.STATIC_FINAL);//如果变量是"编译期常量"，即被static final修饰,那么获取此变量时也不需要初始化该变量所属的类.
        //触发初始化
        System.out.println(Initable.STATIC_FINAL2);//如果变量只是被static或final其中一个修饰，则会触发该变量所在的类的初始化。

        //触发初始化
        System.out.println(Initable2.staticNonFinal);

        Class initable3 = Class.forName("com.java.reflect.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);

    }
}

class Initable {
    static final int STATIC_FINAL  = 47;
    static final int STATIC_FINAL2 = ClassInitialization.rand.nextInt(1000);
    static {
        System.out.println("Initializating Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 147;
    static {
        System.out.println("initializating initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;
    static {
        System.out.println("initializating initable3");
    }
}
