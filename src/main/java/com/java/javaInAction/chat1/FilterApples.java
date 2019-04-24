package com.java.javaInAction.chat1;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.java.javaInAction.bean.Apple;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @创建人 tengcc
 * @创建时间 2019/4/22
 * @描述
 */
public class FilterApples {

    public static void main(String[] args) {
        List<Apple> inventroy= Arrays.asList(new Apple("green",90),
                new Apple("red",120),
                new Apple("yellow",57));


        List<Apple> greenApples=filterGreenApples(inventroy);
        System.out.println("绿苹果:"+ JSON.toJSONString(greenApples));

        List<Apple> weightApples=filterWgithApples(inventroy);
        System.out.println("重量:"+ JSON.toJSONString(weightApples));

        //这种写法还是不明白。 方法引用的写法  其实就是传递方法
        List<Apple> greenApples8=filterApples(inventroy,FilterApples::isGreenApple);
        System.out.println("绿苹果8:"+ JSON.toJSONString(greenApples8));

        List<Apple> weightApples8=filterApples(inventroy,FilterApples::isHeavyApply);
        System.out.println("重量8:"+ JSON.toJSONString(weightApples8));

        //lambda
        List<Apple> greenAppleslambda=filterApples(inventroy,(Apple a)-> "green".equals(a.getColor()));
        System.out.println("绿苹果8lambda:"+ JSON.toJSONString(greenApples8));

        List<Apple> weightAppleslambda=filterApples(inventroy,(Apple a)-> a.getWeight()>100||"green".equals(a.getColor()));
        System.out.println("绿苹果8weightAppleslambda:"+ JSON.toJSONString(weightAppleslambda));


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
     * 重量大于100的苹果
     * @param inventroy
     * @return
     */
    public static List<Apple> filterWgithApples(List<Apple> inventroy){
        List<Apple> result= Lists.newArrayList();
        for(Apple apple:inventroy){
            if(apple.getWeight()>100){
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple){
            return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApply(Apple apple){
        return apple.getWeight()>=120;
    }

    /**
     * java8新写法
     * @param inventroy
     * @param p
     * @return
     */
    public static List<Apple> filterApples(List<Apple> inventroy, Predicate<Apple> p){
        List<Apple> result=Lists.newArrayList();
        for(Apple apple:inventroy){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
}