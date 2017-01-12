package com.java.innerClass;

/**
 * 内部类能访问外部类的所有成员
 * 
 * @author linco lee
 */
public class Parcel3 {
    //普通内部类
    class Contents {

        private int i = 11;

        public int value() {
            return i;
        }
    }

    //普通内部类
    class Desination {
        private String label;

        Desination(String whereTo) {
            label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }

    public static void main(String[] args) {
        Parcel3 p = new Parcel3();
        Parcel3.Contents c = p.new Contents();//创建内部类的引用
        Parcel3.Desination d = p.new Desination("aa");//创建内部类的引用
    }
}
