package com.java.designPattern.proxy.jdk.findlove;

/**
 * 动态代理接口：三个条件
 * 1.动态代理角色：代理角色、被代理角色
 * 2.动态代理注重过程，即事情必须做，但又不想亲自去做，所以找代理。
 * 3.代理必须拥有被代理人的信息
 * @author tengcongcong
 * @create 2017-09-14 18:08
 * @Version 1.0
 **/
public interface Persion {
    /**
     * 相亲
     */
    void findLove();
}
