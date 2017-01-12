package com.java.dataType.bean;

public class IntegerBeanTest {
	private int age;
	private Integer count;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "IntegerBeanTest [age=" + age + ", count=" + count + "]";
	}
	
}
