package com.java.thinkInJava.genericity.chapt15_2_1;

/**
 * 类TupleTest.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月29日 下午9:24:03
 * @version 1.0.0
 */
public class TupleTest {
    public static void main(String[] args) {
        //        main("测试多个main");
        System.out.println(new TwoTuple<String, Integer>("张三", 13));
        System.out.println(new ThreeTuple<TupleType1, String, Integer>(new TupleType1(), "张三", 13));
        System.out.println(new FourTuple<String, Integer, TupleType1, TupleType2>("张三", 13, new TupleType1(),
                new TupleType2()));
        System.out.println(new FiveTuple<String, Integer, String, Integer, Boolean>("李四", 13, "张三", 24, true));

    }

    public static void main(String test) {
        System.out.println("main test:" + test);
    }
}

class TupleType1 {

}

class TupleType2 {

}

class TupleType3 {

}
