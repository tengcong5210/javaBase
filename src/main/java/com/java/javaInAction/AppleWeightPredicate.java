package com.java.javaInAction;

import com.java.javaInAction.bean.Apple;

/**
 * @创建人 tengcc
 * @创建时间 2019/4/24
 * @描述
 */
public class AppleWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple a) {
        return a.getWeight()>100;
    }
}