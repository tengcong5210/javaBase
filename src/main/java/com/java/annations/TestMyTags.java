package com.java.annations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.reflect.Method;
@Deprecated
public class TestMyTags {
	@MyTags
	public void info(){
		System.out.println("-----------");
	}
	
	public static void main(String[] args) {
		Class<TestMyTags> clazz=TestMyTags.class;
		//获取类的注解 ,并打印改注解的元注解
		Deprecated dep=clazz.getAnnotation(Deprecated.class);
		Annotation[] ans =dep.getClass().getAnnotations();
		for(Annotation an:ans){
			Documented docu=(Documented)an;
			System.out.println("类的注解的元注解:"+docu);
		}
		for(Method method:clazz.getDeclaredMethods()){
			MyTags mytags=method.getAnnotation(MyTags.class);
			System.out.println("method:"+method.getName());
			if(mytags!=null){
				System.out.println("mytags.age:"+mytags.age());
				System.out.println("mytags.name:"+mytags.name());
			}
		}
	}
}
