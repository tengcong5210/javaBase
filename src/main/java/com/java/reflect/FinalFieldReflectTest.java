package com.java.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 反射静态final变量
 * @author tengcongcong
 * @create 2018-04-28 9:26
 * @Version 1.0
 **/
public class FinalFieldReflectTest {

    private static final Integer COUNT=10;


    /**
     * 由于COUNT是final修饰的变量，所以不能正确修改
     * @throws Exception
     */
    public static void invoke_1() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("invoke_1->开始");
        Field field=FinalFieldReflectTest.class.getDeclaredField("COUNT");
        field.setAccessible(true);
        //set方法 如果底层字段（obj）是静态字段，则忽略 obj 变量；它可能为 null。
       // 否则底层字段是一个实例字段。如果指定对象变量为 null，则该方法将抛出一个 NullPointerException。
        field.set(null,20);
        System.out.println("invoke_1>结果:"+FinalFieldReflectTest.COUNT);
    }

    public static void invoke_2()throws NoSuchFieldException, IllegalAccessException{
        System.out.println("invoke_2->开始");
        //返回一个 Field 对象，它反映此 Class 对象所表示的类或接口的指定公共成员字段。name 参数是一个 String，用于指定所需字段的简称。
        Field field=FinalFieldReflectTest.class.getField("COUNT");
        field.set(null,20);
        System.out.println("invoke_2>结果:"+FinalFieldReflectTest.COUNT);
    }

    public static void invoke_3()throws NoSuchFieldException, IllegalAccessException{
        System.out.println("invoke_3->开始");
        //返回一个 Field 对象，它反映此 Class 对象所表示的类或接口的指定公共成员字段。name 参数是一个 String，用于指定所需字段的简称。
        Field field=FinalFieldReflectTest.class.getDeclaredField("COUNT");
        field.setAccessible(true);
        //说明 Field 有modifiers 字段的定义
        Field modifiersd=Field.class.getDeclaredField("modifiers");
        modifiersd.setAccessible(true);
        modifiersd.setInt(field,field.getModifiers() &~Modifier.FINAL);//fianl标志位置0
        field.set(null,25);
        System.out.println("invoke_3>结果:"+FinalFieldReflectTest.COUNT);
    }

    public static void main(String[] args)throws Exception {
        //invoke_1();
        //invoke_2();
        invoke_3();

    }
}
