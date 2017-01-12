package com.java.designPattern.singleton;

/**
 * 普通枚举方法
 * @author tengcongcong
 * @create 2016-12-20 11:53
 **/
public class Singletion1 {
    //用类变量做个标识  (为什么将该句代码放到INSTANCE 下面就无效了。)
    private static  boolean flag=false;
    //用类变量做个标识
    //此种方法创建单例有个弊端，无法防止反射攻击.要防止反射攻击，就修改构造器，让它在创建第二个实例的时候抛出异常
    public static final Singletion1 INSTANCE=new Singletion1();
//    private static  boolean flag=false;//因为放在此处构造执行后会重新给flag赋值false
    private Singletion1(){
        synchronized (Singletion1.class){
            if(flag==false){
                flag=!flag;
            }else{
                throw new RuntimeException("Singletion1创建单例失败，存在多个实例");
            }
        }
    }
    public void otherMethod(){
        System.out.println("otherMethod");
    }
}
