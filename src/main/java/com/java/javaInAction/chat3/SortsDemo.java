package com.java.javaInAction.chat3;

import com.alibaba.fastjson.JSON;
import com.java.javaInAction.bean.Apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @创建人 tengcc
 * @创建时间 2019/4/29
 * @描述
 */
public class SortsDemo {

    public static void main(String[] args) {
        List<Apple> inventory= Arrays.asList(new Apple("gree",10),
                new Apple("yellow",12),
                new Apple("red",9),
                new Apple("blue",15));
        //1. 通过创建comparator实例进行排序
        inventory.sort(new AppleComparator());

        //2. 通过内名类 进行排序
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        //3. 使用lambda表达式
        inventory.sort((Apple a1,Apple a2)->a1.getWeight().compareTo(a2.getWeight()));

        //4. 使用comparator中的静态辅助方法
        Comparator<Apple> c=Comparator.comparing((Apple a)->a.getWeight());
        inventory.sort(Comparator.comparing((Apple a)->a.getWeight()));

        //5. 方法引用  ：可以被看做仅仅调用特定方法的Lambda的一种快捷写法.  正序
        inventory.sort(Comparator.comparing(Apple::getWeight));

        System.out.println("正序结果:"+ JSON.toJSONString(inventory));

        //5. 方法引用  ：可以被看做仅仅调用特定方法的Lambda的一种快捷写法. 倒序
        inventory.sort(Comparator.comparing(Apple::getWeight).reversed());
        System.out.println("倒序结果:"+ JSON.toJSONString(inventory));
    }
}