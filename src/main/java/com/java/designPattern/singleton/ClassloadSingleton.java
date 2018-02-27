package com.java.designPattern.singleton;

/**
 * @author tengcongcong
 * @create 2018-02-27 16:42
 * @Version 1.0
 **/
public class ClassloadSingleton {
    private static class SingletonHolder{
        public static ClassloadSingleton singleton=new ClassloadSingleton();
    }
    //这种解决方案的实质是：运行步骤2和步骤3重排序，但是不允许其他线程看见。
    public static ClassloadSingleton getInstance(){
        return SingletonHolder.singleton;
    }
}
