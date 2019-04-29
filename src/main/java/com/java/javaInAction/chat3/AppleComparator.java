package com.java.javaInAction.chat3;

import com.java.javaInAction.bean.Apple;
import org.apache.poi.ss.formula.functions.T;

import java.util.Comparator;

/**
 * @创建人 tengcc
 * @创建时间 2019/4/29
 * @描述
 */
public class AppleComparator implements Comparator<Apple> {
    @Override
    public int compare(Apple o1, Apple o2) {
        return o1.getWeight().compareTo(o2.getWeight());
    }
}