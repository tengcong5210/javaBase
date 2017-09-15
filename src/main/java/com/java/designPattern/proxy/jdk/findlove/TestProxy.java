package com.java.designPattern.proxy.jdk.findlove;

/**
 * @author tengcongcong
 * @create 2017-09-14 18:47
 * @Version 1.0
 **/
public class TestProxy {

    public static void main(String[] args){
        try {
            Persion obj=(Persion) new MeiPo().getInstance(new Xiaoxingxing());
            System.out.println("动态代理类："+obj.getClass());
            obj.findLove();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
