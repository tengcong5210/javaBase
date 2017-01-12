package com.java.classLoader;

public class MyTestClassLoader {

    private static String a = "b";

    private void 获取classpath路径() {
        System.out.println(a);
        System.out.println(this.getClass().getClassLoader().getResource("").toString());
    }

    private void getCurrentClassLoader() {
        System.out.println(this.getClass().getClassLoader());
    }

    public static void main(String[] args) {
        System.out.println(a);
        MyTestClassLoader myClassLoader = new MyTestClassLoader();
        myClassLoader.getCurrentClassLoader();
        myClassLoader.获取classpath路径();

    }

}
