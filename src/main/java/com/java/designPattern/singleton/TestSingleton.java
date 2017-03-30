package com.java.designPattern.singleton;

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @author tengcongcong
 * @create 2016-12-20 12:01
 **/
public class TestSingleton {
    @Test
    public void singleton1Test(){
        System.out.println("开始singleton1Test");
        Singletion1 single=Singletion1.INSTANCE;
        Singletion1 single2=null;//Singletion1.INSTANCE;

        try {
            Class clazz=Singletion1.class;
            Constructor<Singletion1> constructor=clazz.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            single2=constructor.newInstance();
            System.out.println("aaa:"+(single==single2));
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("结束singleton1Test");
    }
    @Test
    public void enumSingletonTest(){
        /*EnumSingleton es1=EnumSingleton.INSTANCE;
        EnumSingleton es2=EnumSingleton.INSTANCE;
        System.out.println(es1==es2);*/
        String proFilePath= "src/main/resources/stone-oss.properties";
        EnumSingleton.INSTANCE.getProperties(proFilePath);
        System.out.println(EnumSingleton.INSTANCE.getProperty("oss.signUrlExpires"));

        String proFilePath2= "src/main/resources/log4j.properties";
        EnumSingleton.INSTANCE.getProperties(proFilePath2);
        System.out.println(EnumSingleton.INSTANCE.getProperty("log4j.rootLogger"));
    }
}
