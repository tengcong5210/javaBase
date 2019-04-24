package com.java.javaInAction;

import com.java.javaInAction.bean.Apple;

/**
 * @创建人 tengcc
 * @创建时间 2019/4/24
 * @描述
 */
public interface ApplePredicate {
    boolean test(Apple a);
}
