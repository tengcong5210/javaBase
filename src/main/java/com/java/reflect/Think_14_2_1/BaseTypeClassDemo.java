package com.java.reflect.Think_14_2_1;

import com.java.oop.MyChildDemo;

/**
 * think in java 14 类型信息 14.2.1类字面量常量
 * 
 * @author tengcongcong
 * @date 2015年11月8日 下午9:11:31
 * @version 1.0.0
 */
public class BaseTypeClassDemo {
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Class booleanClazz = boolean.class;
        Class booleanType = Boolean.TYPE;
        System.out.println("booleanClazz==booleanType:" + (booleanClazz == booleanType));
        System.out.println("booleanClazz is primitive:" + booleanClazz.isPrimitive());
        System.out.println("booleanType is primitive:" + booleanType.isPrimitive());//判断是不是基本数据类型
        booleanClazz.newInstance();

        Class stringClazz = String.class;
        System.out.println("stringClazz is primitive:" + stringClazz.isPrimitive());
        System.out.println("InterfaceNestedClass is isSynthetic:" + MyChildDemo.class.isSynthetic());//如果此类是复合类，则返回 true，否则 false。什么是复合类呢？

        Class charClazz = char.class;
        Class charType = Character.TYPE;
        System.out.println("charClazz==charType:" + (charClazz == charType));

        Class byteClazz = byte.class;
        Class byteType = Byte.TYPE;
        System.out.println("byteClazz==byteType:" + (byteClazz == byteType));

        Class shortClazz = short.class;
        Class shortType = Short.TYPE;
        System.out.println("shortClazz==shortType:" + (shortClazz == shortType));

        Class intClazz = int.class;
        Class intType = Integer.TYPE;
        System.out.println("intClazz==intType:" + (intClazz == intType));

        Class longClazz = long.class;
        Class longType = Long.TYPE;
        System.out.println("longClazz==longType:" + (longClazz == longType));

        Class floatClazz = float.class;
        Class floatType = Float.TYPE;
        System.out.println("floatClazz==floatType:" + (floatClazz == floatType));

        Class doubleClazz = double.class;
        Class doubleType = Double.TYPE;
        System.out.println("doubleClazz==doubleType:" + (doubleClazz == doubleType));

        Class voidClazz = void.class;
        Class voidType = Void.TYPE;
        System.out.println("voidClazz==voidType:" + (voidClazz == voidType));

    }
}
