package com.java.thinkInJava.genericity.chapt_15_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 类New.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月30日 上午7:43:31
 * @version 1.0.0
 */
public class New {
    public static <K, V> Map<K, V> map() {
        return new HashMap<K, V>();
    }

    public static <T> List<T> list() {
        return new ArrayList<T>();
    }

    public static <T> LinkedList<T> lList() {
        return new LinkedList<T>();
    }

    public static <T> Set<T> set() {
        return new HashSet<T>();
    }

    public static <T> Queue<T> queue() {
        return new LinkedList<T>();
    }

    public static void main(String[] args) {
        Map<String, List<String>> map = New.map();
        List<String> list = New.list();
        LinkedList<String> linked = New.lList();
        Set<String> set = New.set();
        Queue<String> queue = New.queue();
    }
}
