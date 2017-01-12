package com.java.thinkInJava.genericity.chapt_15_3_1;

import java.util.Iterator;
import java.util.Random;

/**
 * 类CoffeeGenerator.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月29日 下午10:31:38
 * @version 1.0.0
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {

    private Class[]       types = { Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class };
    private static Random rand  = new Random(47);

    //无参构造
    public CoffeeGenerator() {

    }

    private int size = 0;

    //带参构造
    public CoffeeGenerator(int size) {
        this.size = size;
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        @Override
        public void remove() {

        }

    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
        for (Coffee c : new CoffeeGenerator(5)) {
            System.out.println(c);
        }
    }
}
