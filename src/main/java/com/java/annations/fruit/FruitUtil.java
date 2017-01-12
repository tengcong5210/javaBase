package com.java.annations.fruit;

import java.lang.reflect.Field;

/**
 * 注解助理器
 * @author tcc
 *
 */
public class FruitUtil {
	
	public static void getFruitInfo(Class<?> clazz){
		Field[] fields=clazz.getDeclaredFields();
		for (Field field : fields) {
			if(field.isAnnotationPresent(FruitName.class)){
				FruitName fn=field.getAnnotation(FruitName.class);	
				System.out.println("水果名称："+fn.value());
			}else if(field.isAnnotationPresent(FruitColor.class)){
				FruitColor fc=field.getAnnotation(FruitColor.class);	
				System.out.println("水果颜色："+fc.fruitColor());
			}else if(field.isAnnotationPresent(FruitProvider.class)){
				FruitProvider fp=field.getAnnotation(FruitProvider.class);
				System.out.println("水果供应商编号："+fp.id()+";供应商名称："+fp.name()+";供应商地址："+fp.address());
			}
		}
	}
	
	public static void main(String[] args) {
		getFruitInfo(Apple.class);
	}
}
