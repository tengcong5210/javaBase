package com.java.classLoader;

/**
 * 类StaicTest.java的实现描述：TODO 类实现描述
 * 
 * @Clinit()类构造器 编译器自动收集类中的所有类变量的赋值动作和静态语句块static{}中的语句合并产生的.
 * @init()实例构造器
 * @version 1.0.0
 */
public class StaticTest {
    //类变量 且有赋值动作 会放到Clinit()方法执行
    static int b = 112;
    static int c=getC();
    //静态块  会放到Clinit()中执行
    static {
        System.out.println("1");
    }

    //静态方法 由jvm调用
    public static void main(String[] args) {
        StaticTest stt=new StaticTest();
        StaticTest stt2=new StaticTest();
        staticFunction();
    }

    //类变量 且有赋值动作 会放到Clinit()中执行
    static StaticTest st = new StaticTest();

    /*//静态块  会放到Clinit()中执行
    static {
        System.out.println("1");
    }*/
    //代码块  会在构造器之前执行
    {
        System.out.println("2");
    }

    StaticTest() {
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {
        System.out.println("4");
    }

    int        a = 110;
    private static int getC(){
        System.out.println("xxxxxxxxxxxxx");
        return 2;
    }

}
