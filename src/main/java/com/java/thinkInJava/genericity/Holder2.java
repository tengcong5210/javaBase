package com.java.thinkInJava.genericity;

/**
 * 类Holder2.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月23日 上午8:00:24
 * @version 1.0.0
 */
public class Holder2 {
    private Object o;

    public Holder2(Object o) {
        this.o = o;
    }

    public void setObject(Object o) {
        this.o = o;
    }

    public Object getObject() {
        return o;
    }

    public static void main(String[] args) {
        Holder2 h = new Holder2(new Automobile());
        Automobile a = (Automobile) h.getObject();
        System.out.println("a:" + a);
        h.setObject("set Object");
        String s = (String) h.getObject();
        System.out.println("s:" + s);
        h.setObject(1);
        Integer i = (Integer) h.getObject();
        System.out.println("i:" + i);
    }
}
