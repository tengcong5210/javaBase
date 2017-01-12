package com.java.oop.interfaces;

abstract class StringProcessor implements MyProcessor {
    public String name() {
        return getClass().getSimpleName();
    }

    /**
     * process是接口中的方法，没必须在抽象类中再重新定义一遍，直接在子类中实现即可。因为接口中的方法都是抽象方法
     */
    //    public abstract Object process(MyProcessor p);

    public static String s = "I Want to go to Beijing";

    public static void main(String[] args) {
        MyApply.process(new MyUpcase(), s);
        MyApply.process(new MyDowncase(), s);
        MyApply.process(new MySplitter(), s);
    }
}
