package com.java.innerClass;

import com.java.innerClass.Parcel11.ParcelDestination.AnotherLevel;

/**
 * 嵌套类：将内部类声明加static,即是嵌套类 1）创建嵌套类的对象，不需要其外部类的对象。 2）：不能从嵌套类的对象中访问非静态的外围类对象
 * 
 * @author linco lee
 */
public class Parcel11 {
    //嵌套类1
    private static class ParcelContents implements Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    //嵌套类2
    protected static class ParcelDestination implements Destination {
        private String label;

        private ParcelDestination(String whereTo) {
            label = whereTo;
        }

        public String readLabel() {
            return label;
        }

        public static void f() {
            System.out.println("f()");
        }

        static int x = 10;

        //嵌套类中的嵌套类
        static class AnotherLevel {
            public static void f() {
                System.out.println("outer.x=" + x);//可以编译通过
                //                System.out.println("outer.label=" + label);//编译失败，嵌套类不能访问非静态的外部类成员变量
            }

            static int x = 0;
        }
    }

    //获取嵌套类2
    public static Destination destination(String s) {
        return new ParcelDestination(s);
    }

    //获取嵌套类1
    public static Contents contents() {
        return new ParcelContents();
    }

    //    public static AnotherLevel getAnotherLevel() {
    //        return new AnotherLevel();
    //    }

    public static void main(String[] args) {
        Contents c = new ParcelContents();//contents();
        Destination d = new ParcelDestination("aa");//destination("aa");
        AnotherLevel an = new AnotherLevel();
        an.f();

    }
}
