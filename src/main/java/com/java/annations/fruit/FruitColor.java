package com.java.annations.fruit;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 水果颜色注解
 * @author tcc
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface FruitColor {
   /**
    * 颜色枚举
    * @author zhangy
    *
    */
	public enum Color{BULE,RED,GREEN};
	/**
	 * 颜色属性
	 * @return
	 */
	Color fruitColor() default Color.GREEN;
}
