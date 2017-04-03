package com.java.thread.concurrencyOfArt.chap3;

/**
 * 基于类初始化的初始化解决方案
 * JVM在类初始化阶段，会执行类的初始化。在此期间,JVM会去获取一个锁。
 * 这个锁可以同步多个线程对同一个类型的初始化。
 * 疑问1：什么时候进行初始化，有什么规则？
 * 疑问2：基于类初始化和volatile双重检查锁，哪个更好一点？
 *       通过对比volatile的双重检查锁，和类初始化的安全检查。发现基于类的初始化的方案的实现代码简洁。
 *       但是volatile的双重检查锁有一个额外的优势：
 *       除了可以对静态字段实现延迟的初始化，还可以对实例变量实现延迟初始化
 * 疑问3:何时用volatile和类初始化的方案？
 *      如果对实例变量使用线程安全的延迟加载，请使用基于volatitle方案。
 *      如果需要静态成员变量使用线程安全的延迟，请使用基于类初始化的法案。
 * Created by ibm on 2017/4/3.
 */
public class InstanceFactory {

    private static class InstanceHolder{
      public static Instance instance=new Instance();
    }

    /***
     * Java语言规范，在发现下列任一情况，一个类或接口将被初始化
     * 1).一个类的实例被创建 如:new Instance()
     * 2).一个类声明的静态方法被调用
     * 3).一个类中声明的一个静态字段被赋值
     * 4).类中的静态字段被使用，而且这个字段不是一个常量字段.
     * 5).顶级类，而且一个断言语句嵌套在类内部被执行。
     * @return
     */
    public static Instance getInstance(){
        return InstanceHolder.instance;//这里讲导致InstanceHolder类被初始化
    }

    static class Instance{

    }
}
