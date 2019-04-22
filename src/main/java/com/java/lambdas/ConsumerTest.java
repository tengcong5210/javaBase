package com.java.lambdas;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @创建人 tengcc
 * @创建时间 2018/9/10
 * @描述  参考: http://blog.oneapm.com/apm-tech/226.html
 */
public class ConsumerTest {
    @Test
    public void test1(){
        TestClass testClass=new TestClass();
        //1.1 普通方法 调用testClass 对象的aaa方法
        testClass.aaa("222");
        //1.2 java8 新特性 调用testClass 对象的aaa方法
        Consumer<String> consumer=testClass::aaa;
        consumer.accept("111");

        //System.out.println(testClass::aaa1);

    }
    @Test
    public void test2(){
        //方式一
        Consumer<Integer>  c = x -> { System.out.println(x);};
        //方式二
        //Consumer<Integer>  c = getIntegerConsumer();
        c.accept(2);


    }

    private Consumer<Integer> getIntegerConsumer() {
        return x -> { System.out.println(x);};
    }
}
