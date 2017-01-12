package com.java.thinkInJava.genericity.chapt_15_3_1;

/**
 * 类Coffee.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月29日 下午10:26:39
 * @version 1.0.0
 */
public class Coffee {
    private static long counter = 0;
    private final long  id      = counter++;

    public String toString() {
        return this.getClass().getSimpleName() + "-" + id;
    }
}

class Latte extends Coffee {

}

class Mocha extends Coffee {

}

class Cappuccino extends Coffee {

}

class Americano extends Coffee {

}

class Breve extends Coffee {

}
