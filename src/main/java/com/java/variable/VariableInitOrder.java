package com.java.variable;

/**
 * 变量初始化顺序
 * 
 * @describe 在无继承的情况下，类中变量的初始化顺序为：静态块、静态成员变量、初始化块、实例变量、构造方法，且静态块、变量只会初始化一次
 * @attention1 static方法或是块中不能使用this和super关键字
 *             因为this和super表示对象的引用，只有类被实例化后才有引用，而static方法是类名直接调用
 *             ，不需要new操作。说白了this是操作heap中的内存对象
 * @attention2 静态成员变量初始化操作的两种方式：声明时直接初始化和使用静态块。两种方式会按照在类中出现的顺序（声明顺序）来执行
 * @author linco lee
 */
public class VariableInitOrder {
    /**
     * 默认构造
     */
    public VariableInitOrder() {
        System.out.println("执行构造方法VariableInitOrder()");//order5
        this.name = "李四";
    }

    /**
     * 带参构造
     * 
     * @param name
     */
    public VariableInitOrder(String name) {
        System.out.println("执行构造方法VariableInitOrder(String name)");
        this.name = "王五";
    }

    private String     name = getName();
    /**
     * 初始化块1
     */
    {
        System.out.println("执行初始化块1");//order3
        this.name = "赵六";
    }

    private static int age  = getAge();
    /**
     * 静态初始化1
     */
    static {
        System.out.println("执行静态块1");//order1
        age = 10;
    }

    private static int getAge() {
        System.out.println("初始化静态变量age");//order2
        return 21;
    }

    private String getName() {
        System.out.println("初始化实例变量name");//order4
        return "张三";
    }

    static {
        System.out.println("执行静态块2");
        hobby = "踢足球";
    }
    private static String hobby = "打篮球";

    public static void main(String[] args) {
        VariableInitOrder vio = new VariableInitOrder();//第一次实例化
        System.out.println("vio.name:" + vio.name);
        System.out.println("vio.age:" + VariableInitOrder.age);
        System.out.println("vio.hobby:" + VariableInitOrder.hobby);
        System.out.println("+++++++++++第二次实例化VariableInitOrder对象+++++++++++");
        VariableInitOrder vio2 = new VariableInitOrder("王二小");//第一次实例化
        System.out.println("vio2.name:" + vio2.name);
    }
}
