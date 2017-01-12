package com.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 添加一组元素
 * 
 * @author linco lee
 */
public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = { 6, 7, 8, 9, 10 };
        collection.addAll(Arrays.asList(moreInts));//运行比通过构造方法初始化快的多
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);

        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        list.set(1, 99);//用指定元素替换列表中指定位置的元素（可选操作）。 
        //list.add(21);//此处运行时报错，因为Arrays.asList底层是数组，故不能进行add和delete操作，会java.lang.UnsupportedOperationException 异常
    }
}
