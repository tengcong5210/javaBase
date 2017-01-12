package com.java.thinkInJava.typeInfo.chapter_14_3;

import java.util.ArrayList;
import java.util.List;

/**
 * 类ForNmaeCreator.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月14日 下午3:51:23
 * @version 1.0.0
 */
public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types     = new ArrayList<Class<? extends Pet>>();
    private static String[]                   typeNames = { "com.java.thinkInJava.typeInfo.Mutt",
            "com.java.thinkInJava.typeInfo.Pug", "com.java.thinkInJava.typeInfo.EgyptianMau",
            "com.java.thinkInJava.typeInfo.Manx", "com.java.thinkInJava.typeInfo.Cymric",
            "com.java.thinkInJava.typeInfo.Rat", "com.java.thinkInJava.typeInfo.Mouse",
            "com.java.thinkInJava.typeInfo.Hamster"    };

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for (String name : typeNames) {
                types.add((Class<? extends Pet>) Class.forName(name));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }

}
