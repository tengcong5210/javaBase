package com.java.finalTest;

/**
 * final是一个关键字，可以用于修饰类，成员变量，成员方法。 特点： 它修饰的类不能被继承。 它修饰的成员变量是一个常量。
 * 它修饰的成员方法是不能被子类重写的。 final修饰的常量定义一般都有书写规范,被final修饰的常量名称,所有字母都大写。
 * final修饰成员变量,必须初始化,初始化有两种 显示初始化； 构造方法初始化。 但是不能两个一起初始化
 * 
 * @author linco lee
 */
public class FinalTest {

  /*  final关键字可以用于成员变量、本地变量、方法以及类。
    final成员变量必须在声明的时候初始化或者在构造器中初始化，否则就会报编译错误。
    你不能够对final变量再次赋值。
    本地变量必须在声明时赋值。
    在匿名类中所有变量都必须是final变量。
    final方法不能被重写。
    final类不能被继承。
    final关键字不同于finally关键字，后者用于异常处理。
    final关键字容易与finalize()方法搞混，后者是在Object类中定义的方法，是在垃圾回收之前被JVM调用的方法。
    接口中声明的所有变量本身是final的。
    final和abstract这两个关键字是反相关的，final类就不可能是abstract的。
    final方法在编译阶段绑定，称为静态绑定(static binding)。
    没有在声明时初始化final变量的称为空白final变量(blank final variable)，它们必须在构造器中初始化，或者调用this()初始化。不这么做的话，编译器会报错“final变量(变量名)需要进行初始化”。
    将类、方法、变量声明为final能够提高性能，这样JVM就有机会进行估计，然后优化。
    按照Java代码惯例，final变量就是常量，而且通常常量名要大写：
*/
    /**
     * final 成员变量初始化的2种方式 ：1.显示初始化 2.构造初始化
     */
    public final String        HELLWORD;
    /**
     * final 类变量初始化
     */
    public final static String HELLOZHANG;

    public FinalTest() {
        HELLWORD = "hello word";
    }

    static {
        HELLOZHANG = "abc";
    }

    private final int valueOne = 10;

    //    static {
    //        HELLWORD = "hello word";
    //    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FinalTest ft = new FinalTest();
        //ft.valueOne++;  //此处编译报错 因为定义了final 
    }

}
