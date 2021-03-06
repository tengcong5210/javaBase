package com.java.reflect;



public class Person {
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int    age;
    /**
     * 性别
     */
    private char   sex;
    
    public Person(){
    	System.out.println("默认构造");
    }
    
    public Person(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", sex=" + sex + "]";
    }

}
