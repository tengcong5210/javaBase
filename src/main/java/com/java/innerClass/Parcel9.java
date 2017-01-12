package com.java.innerClass;

/**
 * 匿名内部类使用外部类要使用final
 * 
 * @author linco lee
 */
public class Parcel9 {
    //命名内部来使用外部类的对象，必须加fianl
    public Destination destination(final String dest) {
        //创建anonymity inner class
        return new Destination() {
            private String label = dest;

            public String readLabel() {
                //                dest = "aaaa"; 不能再对final 变量进行赋值
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("张三");
        System.out.println(d.readLabel());
    }
}
