package com.java.collection.linkedList;

import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by ibm on 2017/5/6.
 */
public class LinkedJunitTest {
    /**
     * LinkedList源码添加元素分析:
     * step1:创建实例,会调用默认构造函数
     * step2:调用add()方法，执行逻辑:linkLast(e);
     *
     */
    @Test
    public void testCreatedLinked(){
        LinkedList<Integer> linkedList=new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);
    }

}
