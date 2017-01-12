package com.java.reflect;


import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import org.junit.Test;


/**
 * 并发编程网示例
 * http://ifeve.com/java-reflection-constructors/
 * @author tengcongcong
 *
 */
public class MyReflectionTest {
	
	
	
	/**
	 * 反射_constructor(构造函数)
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws Exception
	 */
	@Test
	public void testConstructor() throws Exception  {
		Class clazz=Person.class;
		Constructor cons=clazz.getConstructor(null);
		System.out.println("无参数构造:"+cons.getName());
		Person per=(Person)cons.newInstance(null);
		
		Constructor<?> consWithArgument=clazz.getConstructor(String.class,int.class,char.class);
		Person per1=(Person)consWithArgument.newInstance("张三",20,'男');
		System.out.println("per1:"+per1);
		
	}
	/**
	 * 反射_变量(variable)
	 * @throws Exception
	 */
	@Test
	public void testRefVariable() throws Exception {
		Class<?> clazz=Person.class;
		//1.获取Person中的定义的变量（注意只限于public）
		Field[] fields=clazz.getFields();
		for (Field field : fields) {
			System.out.println("fieldName1="+field.getName());
		}
		//2.获取Person中的定义的变量（包括公共、保护、默认（包）访问和私有字段，但不包括继承的字段）
		Field[] fileds2=clazz.getDeclaredFields();
		for (Field field : fileds2) {
			System.out.println("fieldName2="+field.getName());
			System.out.println("fieldType2="+field.getType().getName());
		}
		//3.get/set 赋值
		Person p=new Person();
		Field field=p.getClass().getDeclaredField("name");
		field.setAccessible(true);
		field.set(p, "李四");//将指定对象变量上此 Field 对象表示的字段设置为指定的新值。如果底层字段的类型为基本类型，则对新值进行自动解包。
		String value=(String)field.get(p);//返回指定对象上此 Field 表示的字段的值。
		field.setAccessible(false);
		System.out.println("Field get Value:"+value);
		
	}
	
}
