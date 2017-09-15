package com.java.designPattern.proxy.jdk.sale;

/**
 * 生产土豆者（被代理对象），找人帮卖，自己不想卖
 * @author tengcongcong
 * @create 2017-09-15 14:30
 * @Version 1.0
 **/
public class ProducerSale implements Sale {

    public void sale() {
        System.out.println("我要卖土豆");
    }
}
