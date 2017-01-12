package com.java.innerClass;

public class ServiceImpl1 implements Service {
    /**
     * 私有构造函数
     */
    private ServiceImpl1() {

    }

    @Override
    public void method1() {
        System.out.println("serviceImpl1.method1");
    }

    @Override
    public void method2() {
        System.out.println("serviceImpl1.method2");
    }

    public static ServiceFactory factory = new ServiceFactory() {

                                             @Override
                                             public Service getService() {
                                                 return new ServiceImpl1();
                                             }
                                         };

}
