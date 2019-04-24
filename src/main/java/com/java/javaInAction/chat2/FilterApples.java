package com.java.javaInAction.chat2;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.java.javaInAction.AppleGreenPredicate;
import com.java.javaInAction.ApplePredicate;
import com.java.javaInAction.AppleWeightPredicate;
import com.java.javaInAction.bean.Apple;

import java.util.Arrays;
import java.util.List;

/**
 * @创建人 tengcc
 * @创建时间 2019/4/24
 * @描述
 */
public class FilterApples {

    public static void main(String[] args) {
        List<Apple> inventroy= Arrays.asList(new Apple("green",90),
                new Apple("red",120),
                new Apple("yellow",57));

        //绿色苹果
        List<Apple> greeApples=filterGreenApples(inventroy);
        //红色苹果
        List<Apple> redApples=filterApplesByColor(inventroy,"red");
        //绿色苹果2
        List<Apple> greeApples2=filter(inventroy,new AppleGreenPredicate());

        //重量大于100的苹果
        List<Apple> heaveyApples=filterApplesByWeight(inventroy,100);

        //重量大于100的苹果2
        List<Apple> heaveyApples2=filter(inventroy,new AppleWeightPredicate());

        //红色苹果 匿名类方式
        List<Apple> redApples2=filter(inventroy, new ApplePredicate() {
            @Override
            public boolean test(Apple a) {
                return "red".equals(a.getColor());
            }
        });
        //红色苹果 lambda 表达式
        List<Apple> redApples3=filter(inventroy,(Apple a)-> "red".equals(a.getColor()));

        System.out.println("红色苹果:"+ JSON.toJSONString(redApples3));



    }

    /**
     * 赛选绿苹果
     * @param inventroy
     * @return
     */
    public static List<Apple> filterGreenApples(List<Apple> inventroy){
        List<Apple> result= Lists.newArrayList();
        for(Apple apple:inventroy){
            if("green".equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 赛选绿苹果
     * @param inventroy
     * @return
     */
    public static List<Apple> filterApplesByColor(List<Apple> inventroy,String color){
        List<Apple> result= Lists.newArrayList();
        for(Apple apple:inventroy){
            if(apple.getColor().equals(color)){
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 重量大于100的苹果
     * @param inventroy
     * @return
     */
    public static List<Apple> filterApplesByWeight(List<Apple> inventroy,int weight){
        List<Apple> result= Lists.newArrayList();
        for(Apple apple:inventroy){
            if(apple.getWeight()>weight){
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 过滤
     * @param inventroy
     * @param predicate
     * @return
     */
    public static List<Apple> filter(List<Apple> inventroy, ApplePredicate predicate){
        List<Apple> result= Lists.newArrayList();
        for(Apple apple:inventroy){
            if(predicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
}