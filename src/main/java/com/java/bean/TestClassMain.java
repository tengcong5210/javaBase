package com.java.bean;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Method;
import java.util.HashMap;

public class TestClassMain {

    public TestClassMain() throws ClassNotFoundException {

    }


    public static void main(String[] args) throws ClassNotFoundException

    {

        // TODO Auto-generated method stub

        // 设置类成员属性

        HashMap propertyMap = new HashMap();

        propertyMap.put("id", Class.forName("java.lang.Integer"));

        propertyMap.put("name", Class.forName("java.lang.String"));

        propertyMap.put("address", Class.forName("java.lang.String"));

        // 生成动态 Bean

        CodeCreate bean = new CodeCreate(propertyMap);

        // 给 Bean 设置值

        bean.setValue("id", new Integer(123));

        bean.setValue("name", "454");

        bean.setValue("address", "789");

        // 从 Bean 中获取值，当然了获得值的类型是 Object

        System.out.println("  >> id      = " + bean.getValue("id"));

        System.out.println("  >> name    = " + bean.getValue("name"));

        System.out.println("  >> address = " + bean.getValue("address"));

        // 获得bean的实体

        Object object = bean.getObject();

        System.out.println("object json:"+ JSON.toJSONString(object));

        // 通过反射查看所有方法名

        Class clazz = object.getClass();

        Method[] methods = clazz.getDeclaredMethods();

        for (int i = 0; i < methods.length; i++) {

        //System.out.println(methods[i].getName());
            try {
                System.out.println(methods[i].getName()+":"+ methods[i].invoke(object));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}