package com.java.collection.linkedList;

import com.alibaba.fastjson.JSON;
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
    @Test
    public void testCustomLinked(){
        CustomLinked<String> customLinked=new CustomLinked<String>();
        customLinked.add("a");
        customLinked.add("b");
        customLinked.add("c");
        System.out.println(JSON.toJSONString(customLinked));
    }
    @Test
    public void testMyLinkedList1(){
        MyLinkedList1<String> linkedList1=new MyLinkedList1<String>();
        linkedList1.add("aaa");
        linkedList1.add("bbb");
        linkedList1.add("ccc");
        linkedList1.add("ddd");
        System.out.println(JSON.toJSONString(linkedList1));
    }

}
