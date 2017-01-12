package com.java.annations.fruit;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 水果供应商注解
 * @author tcc
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface FruitProvider {
	//供应商编号
	public int id() default -1;
	//供应商名称
	public String name() default "";
	//供应商地址
	public String address() default "";
}
