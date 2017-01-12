package com.java.oop.Initialize;

/**
 * 类及成员初始化
 * 
 * @author tengcongcong
 * @date 2015年10月24日 上午10:48:12
 * @version 1.0.0
 */
public class PersonInitializeDemo {

    public PersonInitializeDemo() {
        System.out.println("无参构造方法");
    }

    private String sex = showSex();

    {
        System.out.println("构造代码块A:");
    }

    public PersonInitializeDemo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * @return
     */
    private String showSex() {
        System.out.println("显示性别");
        return "女";
    }

    private String        name    = "张三";
    private int           age;
    private String        hobby   = showHobby();
    private static String country = "china";

    {
        System.out.println("构造代码块B:" + name + ";age:" + age);
    }

    static {
        System.out.println("静态代码块B");
    }

    public String getName() {
        return name;
    }

    /**
     * @return
     */
    private String showHobby() {
        System.out.println("兴趣爱好");
        return "打篮球";
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

    static {
        System.out.println("静态代码块A");
    }

    /**
     * 当main方法被jvm执行，内存分配情况如下：1)、 line1:main方法入栈，创建PersonInitializeDemo 对象的引用pid
     * 2）new PersonInitializeDemo() 当new的时候（注意如果没有new，Person
     * p=null类似这样不会被加载），将PersonInitializeDemo.class加载到heap
     * 3）如果有静态代码块，则静态代码块被执行，给class类进行初始化
     * ，注意【静态代码块只会被初始化一次】。4)在heap中分配空间，并分配内存地址。 5）在heap中创建对象属性，并进行默认初始化。
     * 6）显示初始化。7）构造代码块初始化。8）构造函数初始化 9）将heap中的内存地址赋值给pid
     * 
     * @param args
     */
    public static void main(String[] args) {
        PersonInitializeDemo pid = new PersonInitializeDemo();//line1
    }

}
