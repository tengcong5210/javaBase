package com.java.innerClass;

public class Factories {

    public static void serviceConsumer(ServiceFactory factory) {
        Service s = factory.getService();
        s.method1();
        s.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(ServiceImpl1.factory);
        serviceConsumer(ServiceImpl2.factory);
        /**
         * 构造方法被私有化了（private）,不能实例化
         */
        //        ServiceImpl1 s1 = new ServiceImpl1();
        //        ServiceImpl2 s2 = new ServiceImpl2();
    }
}
