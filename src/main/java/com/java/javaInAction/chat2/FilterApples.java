package com.java.javaInAction.chat2;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.java.javaInAction.AppleGreenPredicate;
import com.java.javaInAction.ApplePredicate;
import com.java.javaInAction.AppleWeightPredicate;
import com.java.javaInAction.bean.Apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @创建人 tengcc
 * @创建时间 2019/4/24
 * @描述
 */
public class FilterApples {

    public static void main(String[] args) {
        List<Apple> inventroy= Arrays.asList(new Apple("green",90,1.0),
                new Apple("red",120,2.5),
                new Apple("yellow",57,3.8));

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

        //三选大于10的数据
        List<Integer> numbers=Arrays.asList(1,4,39,26,34,8,15);

        List<Integer> integers=filterT(numbers,(Integer i)->i>10);

        System.out.println("大于10的数据:"+ JSON.toJSONString(integers));
        //匿名类
        integers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println("大于10的数据排序:"+ JSON.toJSONString(integers));
        //lambda 表达式
        integers.sort((Integer o1,Integer o2)->o2.compareTo(o1));

        System.out.println("大于10的数据排序lambda:"+ JSON.toJSONString(integers));

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

    /**
     * 泛型过滤
     * @param list
     * @param p
     * @param <T>
     * @return
     */
    public static <T> List<T> filterT(List<T> list, Predicate<T> p){
        List<T> result=Lists.newArrayList();
        for(T e:list){
            if(p.test(e)){
                result.add(e);
            }
        }
        return result;
    }
}