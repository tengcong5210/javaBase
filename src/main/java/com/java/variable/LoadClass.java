package com.java.variable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 类的加载
 * 
 * @author linco lee
 */
public class LoadClass {
    public static void main(String[] args) {
        //        Bucket bucket;
        //        Bucket bucket1 = new Bucket();
        //        int height = Bucket.height;
        //        Bucket.vohume();

        try {
            long time1 = System.currentTimeMillis();
            Class<?> c = Class.forName("com.java.variable.Bucket");
            Method method = c.getDeclaredMethod("forSysTest");
            method.invoke(new Bucket());

            long time2 = System.currentTimeMillis();
            Bucket b = new Bucket();
            b.forSysTest();
            long time3 = System.currentTimeMillis();

            System.out.println("result1:" + (time2 - time1));
            System.out.println("result2:" + (time3 - time2));
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Bucket {
    static {
        System.out.println("载入类....");
    }
    public static int height = 30;

    public static float vohume() {
        return 23.5f;
    }

    public void forSysTest() {
        int count = 100000;
        for (int i = 0; i < count; i++) {
            System.out.println("第" + i + "次输出");
        }
    }
}
