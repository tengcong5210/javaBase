package com.java.javaInAction.chat3;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @创建人 tengcc
 * @创建时间 2019/4/28
 * @描述
 */
public class FunctionDemo {


    public static void main(String[] args) {

        List<String> strings= Arrays.asList("张三三","王柳","蓄势待发的");
        //1.内名内部类写法
        FunctionF<String,Integer> ff=new FunctionF<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };

        List<Integer> result=map(strings,ff);
        System.out.println("内名内部类写法："+ JSON.toJSONString(result));

        //2.lambda表达式写法
        FunctionF<String,Integer> strs=(String s)->s.length();

        List<Integer> result2=map(strings,strs);
        System.out.println("lambda写法："+ JSON.toJSONString(result2));




    }

    public static <T,R> List<R> map(List<T> list,FunctionF<T,R> f){
        List<R> result=new ArrayList<>();
        for(T t:list){
            result.add(f.apply(t));
        }
        return result;
    }
}