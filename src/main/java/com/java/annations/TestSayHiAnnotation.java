package com.java.annations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestSayHiAnnotation {
	
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		SayHiElement she=new SayHiElement();
		
		she.sayHiDeFault("普通");
		//普通传参，不用注解
		she.sayHiAnnotation("注解");
		she.sayHiAnnotationDefault("默认注解");
		System.out.println("################################");
		//用注解传参数，用到注解就得用反射
		Class<? extends SayHiElement> sheClazz=she.getClass();
		Method[] methods=sheClazz.getDeclaredMethods();
		for (Method method : methods) {
			SayHiAnnotation shno=null;
			System.out.println("method:"+method.getName());
			if((shno=method.getAnnotation(SayHiAnnotation.class))!=null){
				method.invoke(she, shno.paramValue());
			}else{
				method.invoke(she, "反射普通");
			}
			
		}
		
		
	}
}
