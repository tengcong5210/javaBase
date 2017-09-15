package com.java.designPattern.proxy.jdk.findlove;

/**
 * //回顾一下，满足代理模式应用场景的三个必要条件，穷取法
 //1、两个角色：执行者、被代理对象
 //2、注重过程，必须要做，被代理对象没时间做或者不想做（怕羞羞），不专业
 //3、执行者必须拿到被代理对象的个人资料（执行者持有被代理对象的引用）
 * @author tengcongcong
 * @create 2017-09-14 18:09
 * @Version 1.0
 **/
public class Xiaoxingxing implements Persion {

    public void findLove() {
      System.out.println("找对象标准：");
      System.out.println("1：高富帅");
      System.out.println("2：有房有车");
      System.out.println("3：身高170以上；体重70Kg!");
    }
}
