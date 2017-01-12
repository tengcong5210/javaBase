package com.java.thinkInJava.typeInfo.chapter_14_3;

/**
 * 类Pet.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月14日 上午11:44:50
 * @version 1.0.0
 */
public class Pet extends Individual {
    //注意 如果父类只定义了带参数的构造器，那么子类必须实现父类构造器。因为不实现父类带参构造函数，就去父类没有默认构造器供子类调用
    public Pet(String name) {
        super(name);
    }

    public Pet() {
        super();
    }
}
