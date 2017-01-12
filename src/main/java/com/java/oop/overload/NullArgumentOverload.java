package com.java.oop.overload;

import java.util.ArrayList;
import java.util.List;

/**
 * 类NullArgumentOverload.java的实现描述：TODO 类实现描述
 * 重载是在编译期就已经确定了的，并不需要等到运行时才能确定。这也是为什么说它不是多态的一个原因
 * 
 * @author tengcongcong
 * @date 2015年10月29日 下午12:49:30
 * @version 1.0.0
 */
public class NullArgumentOverload {
    public static void main(String[] args) {
        NullArgumentOverload nullObj = new NullArgumentOverload();
        nullObj.overload(null);//输出结果竟然是array overload,Why?

        NullArgumentOverload ovr2 = new NullArgumentOverload();
        ovr2.overlist(null);
        /**
         * 程序输出：List arguement
         * method.。显然这里重载对于传入的参数类型只认了引用的类型，并没有去解析实际对象的类型。如果重载是一种多态的话
         * ，它这里应该去解析实际对象的类型并调用ArrayList的方法。
         */
        List list = new ArrayList();
        ovr2.overlist(list);
    }

    /**
     * 该方法可以接受任务类型的参数，缺乏精确性
     * 
     * @param obj
     */
    public void overload(Object obj) {
        System.out.println("obj overload");
    }

    /**
     * 该方法会被调用，因为double[] 比 object更精确
     * 
     * @param objs
     */
    public void overload(double[] objs) {
        System.out.println("array overload");
    }

    /**
     * 增加此方法会编译不过，String的
     * overLoad和double[]的overLoad都可以匹配，但是两者在继承属上是平行的，因此编译器也不知道到底该调用哪一个重载方法。另外这段
     * 代码还说明了一个问题：重载是在编译期就已经确定了的，并不需要等到运行时才能确定。这也是为什么说它不是多态的一个原因。
     * 
     * @param str
     */
    //    public void overload(String str) {
    //        System.out.println("String overload");
    //    }

    public void overlist(List list) {
        System.out.println("list overload");
    }

    public void overlist(ArrayList arraylit) {
        System.out.println("arraylit overload");
    }
}
