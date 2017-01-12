package com.java.innerClass;

public class ServiceImpl2 implements Service {
    /**
     * 私有构造函数2
     */
    private ServiceImpl2() {

    }

    @Override
    public void method1() {
        System.out.println("serviceImpl2.method1");
    }

    @Override
    public void method2() {
        System.out.println("serviceImpl2.method2"); // TODO Auto-generated method stub

    }

    public static ServiceFactory factory = new ServiceFactory() {

                                             @Override
                                             public Service getService() {
                                                 return new ServiceImpl2();
                                             }
                                         };

}
