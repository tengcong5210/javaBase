package com.java.reflect.Think_14_2_2;

/**
 * 类GenericClassReferences.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月9日 上午7:26:11
 * @version 1.0.0
 */
public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class;
        intClass = double.class;
        //        genericIntClass=double.class;//Illegal

        //        Class<Number> genericNumberClass = int.class;//Illegal
    }

    /**
     * 采用通配符
     */
    public static void wildcardClassReferences() {
        Class<?> intClass = int.class;
        intClass = double.class;
    }

    /**
     * 通配符+extends
     */
    public static void boundClassReferences() {
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
    }
}
