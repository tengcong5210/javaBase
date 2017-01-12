package com.java.thinkInJava.typeInfo.chapter_14_9;

import java.lang.reflect.Field;

/**
 * 通过反射访问field域
 * 
 * @author tengcongcong
 * @date 2015年11月22日 上午11:25:13
 * @version 1.0.0
 */
class WithPrivateFinalField {
    private int          i  = 1;
    private final String s  = "I'm totally safe";
    private String       s2 = "Am is safe?";

    public String toString() {
        return "i=" + i + ";s=" + s + ";s2=" + s2;
    }
}

public class ModifyPrivateFields {
    public static void main(String[] args) throws Exception {
        WithPrivateFinalField pf = new WithPrivateFinalField();

        Field fi = pf.getClass().getDeclaredField("i");
        fi.setAccessible(true);
        System.out.println("fi.get(pf):" + fi.get(pf));
        fi.set(pf, 2);
        System.out.println("i change:" + pf);

        Field fs = pf.getClass().getDeclaredField("s");
        fs.setAccessible(true);
        System.out.println("fs.get(pf):" + fs.get(pf));
        fs.set(pf, "no,yor're not ");
        System.out.println("fs change:" + pf);

        Field fs2 = pf.getClass().getDeclaredField("s2");
        fs2.setAccessible(true);
        System.out.println("fs2.get(pf):" + fs2.get(pf));
        fs2.set(pf, "No,you're not!");
        System.out.println(pf);

    }
}
