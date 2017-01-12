package com.java.thinkInJava.typeInfo.chapter_14_3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 类TypeCounter.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月14日 下午7:33:51
 * @version 1.0.0
 */
public class TypeCounter extends HashMap<Class<?>, Integer> {
    private Class<?> baseType;

    public TypeCounter(Class<?> baseType) {
        this.baseType = baseType;
    }

    public void count(Object obj) {
        Class<?> type = obj.getClass();
        if (!baseType.isAssignableFrom(type)) {
            throw new RuntimeException();
        }
        countClass(type);
    }

    private void countClass(Class<?> type) {
        Integer quantity = get(type);
        put(type, quantity == null ? 1 : quantity + 1);
        Class<?> superClass = type.getSuperclass();
        if (superClass != null && baseType.isAssignableFrom(type)) {
            countClass(superClass);
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder("{");
        for (Map.Entry<Class<?>, Integer> pair : entrySet()) {
            result.append(pair.getKey().getSimpleName());
            result.append("=");
            result.append(pair.getValue() == null ? 0 : pair.getValue());
            result.append(",");
        }
        result.delete(result.length() - 1, result.length());
        result.append("}");
        return result.toString();
    }

    public static void main(String[] args) {
        TypeCounter typeCounter = new TypeCounter(Collection.class);
        ArrayList<String> list = new ArrayList<String>();
        typeCounter.count(list);

        System.out.println(typeCounter);
    }
}
