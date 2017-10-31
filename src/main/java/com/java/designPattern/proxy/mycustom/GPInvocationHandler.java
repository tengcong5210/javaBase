package com.java.designPattern.proxy.mycustom;

import java.lang.reflect.Method;

/**
 * 自定义代理处理器
 * @author tengcongcong
 * @create 2017-09-30 16:47
 * @Version 1.0
 **/
public interface GPInvocationHandler {

    public Object invoke(Object proxy, Method method,Object[] args) throws Throwable;
}
