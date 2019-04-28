package com.java.javaInAction.chat3;

/**
 * @创建人 tengcc
 * @创建时间 2019/4/28
 * @描述
 */
@FunctionalInterface
public interface FunctionF<T,R> {
    R apply(T t);
}
