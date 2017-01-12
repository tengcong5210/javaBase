package com.java.innerClass;

/**
 * 匿名内部类
 * 
 * @author linco lee
 */
public class AnonymityClassDemo {
    /**
     * 要这样使用 必须继续一个父类或是 实现某一个接口
     * 
     * @return
     */
    public Contents contents() {
        //return 的是contents的子类
        return new Contents() {
            private int i = 11;

            public int value() {
                return i;
            }
        };
    }

    public static void main(String[] args) {
        AnonymityClassDemo ac = new AnonymityClassDemo();
        Contents c = ac.contents();

    }
}

class Contents2 {
    public int getValue() {
        return 2;
    }
}

class anonymityClassDemo2 {

    class MyContents2 extends Contents2 {
        private int i = 11;

        public int getValue() {
            return i;
        }
    }

    public Contents2 getContents2() {
        return new MyContents2();
    }

    public static void main(String[] args) {
        anonymityClassDemo2 ac2 = new anonymityClassDemo2();
        Contents2 c2 = ac2.getContents2();
        c2.getValue();
    }
}
