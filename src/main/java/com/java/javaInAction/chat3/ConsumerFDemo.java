package com.java.javaInAction.chat3;

import java.util.Arrays;
import java.util.List;

/**
 * @创建人 tengcc
 * @创建时间 2019/4/28
 * @描述
 */
public class ConsumerFDemo {

    public static void main(String[] args) {

        List<Integer> nums= Arrays.asList(1,3,7,9,4,5,10);

        //1 匿名内部类的写法
        ConsumerF<Integer> c=new ConsumerF<Integer>() {
            @Override
            public void accept(Integer integer) {
                //对integer进行操作
                System.out.println("内名内部类写法："+integer);
            }
        };
        foreach(nums,c);

        //2 lambda表达式写法
        ConsumerF<Integer> lambdaC=(Integer i)->System.out.println("lambda表达式写法:"+i);
        foreach(nums,lambdaC);



    }

    public static <T> void foreach(List<T> list,ConsumerF<T> c){
        for(T t:list){
            c.accept(t);
        }
    }

}