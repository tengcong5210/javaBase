package com.java.collection.list;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 类ArrayListTest.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2016年3月7日 下午11:42:04
 * @version 1.0.0
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i <= 16; i++) {
            list.add(i);
        }
    }

    /**
     * 删除List 错误方法一
     * 
     * @param list
     * @return
     */
    private static void removeList_no(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.equals("b")) {
                list.remove(s);
            }
        }
    }

    /**
     * 删除List 正确方法一
     * 
     * @param list
     * @return
     */
    private static void removeList_yes(ArrayList<String> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            String s = list.get(i);
            if (s.equals("b")) {
                list.remove(s);
            }
        }
    }

    /**
     * 删除List 错误方法二
     * 
     * @return
     */
    private static void removeList2_no(ArrayList<String> list) {
        for (String str : list) {
            if (str.equals("b")) {
                list.remove(str);
            }
        }
    }

    /**
     * 删除List 正确方法二
     * 
     * @return
     */
    private static void removeList2_yes(ArrayList<String> list) {
        Iterator<String> ite = list.iterator();
        while (ite.hasNext()) {
            String s = ite.next();
            if (s.equals("b")) {
                ite.remove();
            }
        }
    }
}
