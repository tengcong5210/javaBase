package com.java.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 容器打印：主要是观察list、set、map的特性
 * 
 * @author linco lee
 */
public class PrintingContainers {
    static Collection fill(Collection<String> collection) {
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        collection.add("dog");
        return collection;
    }

    static Map fill(Map<String, String> map) {
        map.put("rat", "张三");
        map.put("cat", "李四");
        map.put("dog", "王五");
        map.put("dog", "王六");
        return map;
    }

    public static void main(String[] args) {
        /**
         * arrayList和linkedList都是按照插入顺序保存元素，不同之处在于执行某些类型的操作时的性能
         */
        System.out.println("=============list================");
        System.out.println(fill(new ArrayList<String>()));
        System.out.println(fill(new LinkedList<String>()));

        /**
         * hashset、treeSet、linkedSet
         * 都是set类型，相同的项只能保存一次（即不允许重复），但三者又有区别：hashset获取元素最快
         * ，无序；TreeSet有序按照比较结果进行升序；linkedHashset按照添加的顺序保存对象
         */
        System.out.println("=============set================");
        System.out.println(fill(new HashSet<String>()));
        System.out.println(fill(new TreeSet<String>()));
        System.out.println(fill(new LinkedHashSet<String>()));

        /**
         * hashmap提供了最快的查找技术，没有按照任何明显的顺序保存键；TreeMap按照比较结果的升序保存键；
         * linkedHashMap按照插入顺序保存键,同时还保存了HashMap的查询速度
         */
        System.out.println("=============map================");
        System.out.println(fill(new HashMap()));
        System.out.println(fill(new TreeMap()));
        System.out.println(fill(new LinkedHashMap()));
    }
}
