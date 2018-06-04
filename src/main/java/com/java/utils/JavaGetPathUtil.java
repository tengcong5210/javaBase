package com.java.utils;

import org.junit.Test;

/**
 * @author tengcongcong
 * @create 2018-06-04 16:53
 * @Version 1.0
 **/
public class JavaGetPathUtil {

    /**
     * 获取当前类的所在工程路径;
     */
    @Test
    public void testGetPath(){
        System.out.println(this.getClass().getResource("").getPath());
    }

    /**
     * 获取当前工程src目录下selected.txt文件的路径
     */
    @Test
    public void testGetResourcePath(){
        System.out.println(this.getClass().getClassLoader().getResource("log4j.properties"));
    }

    /**
     * 获取当前工程路径
     */
    @Test
    public void testSystemPath(){
        System.out.println(System.getProperty("user.dir"));
    }

}
