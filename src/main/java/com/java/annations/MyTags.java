package com.java.annations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//定义一个注解
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)//注解的生命周期
@Inherited //该注解有继承性，如果有类A使用此注解，类B继承自类A,则类B也将被该注解修饰
public @interface MyTags {
  //注解的默认值 ，如果有默认值，在使用注解的时候 可以直接用 @MyTags，
  //否则必须指定注解成员变量@MyTags(name="张三",age=20)
  String name() default "默认";
  int age() default 18;
}
