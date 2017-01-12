package com.java.innerClass;

/**
 * 类MyContextClassLoaderLocal.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年10月17日 上午10:01:25
 * @version 1.0.0
 */
public class MyContextClassLoaderLocal {
    {
        System.out.println("父类代码块");
    }

    protected void defaultPrint() {
        System.out.println("defaualt");
    }
}
