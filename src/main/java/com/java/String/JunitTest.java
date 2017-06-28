package com.java.String;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * junit测试
 * Created by ibm on 2017/4/20.
 */
public class JunitTest {
    @Test
    public void testHelloWorld(){
        System.out.println("HelloWorld");
    }

    /**
     * 在testHelloWorld()方法执行前执行
     */
    @Before
    public void testBefore(){
        System.out.println("before");
    }
    /**
     * 在testHelloWorld()方法执行后执行
     */
    @After
    public void testAfter(){
        System.out.println("after");
    }
}
