package com.java.reflect.Think_14_2_2;

import java.util.ArrayList;
import java.util.List;

/**
 * 类FilledList.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月9日 上午7:48:18
 * @version 1.0.0
 */
public class FilledList<T> {
    private Class<T> type;

    public FilledList(Class<T> type) {
        this.type = type;
    }

    public List<T> create(int nElement) {
        List<T> result = new ArrayList<T>();
        try {
            for (int i = 0; i < nElement; i++) {
                result.add(type.newInstance());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) {
        FilledList<CountedInteger> fl = new FilledList<CountedInteger>(CountedInteger.class);
        System.out.println(fl.create(15));
    }
}

class CountedInteger {
    private static long counter;
    private final long  id = counter++;

    public String toString() {
        return Long.toString(id);
    }

    public CountedInteger() {
        System.out.println("无参构造");
    }

    //CountedInteger 类必须提供默认构造器（无参构造），否则通过Class.newInstance来实例化会报错
    public CountedInteger(int i) {
        System.out.println("有参构造");
    }
}
