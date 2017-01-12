package com.java.innerClass;

/**
 * 内部类拥有对外部类所有成员的访问权（不管你是不是private都可访问）
 * 
 * @author linco lee
 */
public class Sequence {
    private int      next = 0;
    //注意此处是private
    private Object[] items;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        /**
         * 这里内部类访问外部类的items属性，即使items是pirvate，对应内部类来说仍然是可以访问的
         */
        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }

    }

    //通过 外部类访问 内部类
    public Selector getSelector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(i);
        }
        Selector selector = sequence.new SequenceSelector();
        while (!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }
    }
}
