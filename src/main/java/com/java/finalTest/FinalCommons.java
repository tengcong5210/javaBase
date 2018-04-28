package com.java.finalTest;

import java.lang.reflect.Field;

/**
 * @author tengcongcong
 * @create 2018-04-28 10:37
 * @Version 1.0
 **/
public class FinalCommons {

    private final String str_key="张三";

    public String getStr_key() {
        return str_key;
    }
    // 针对 final变量 Intellij都不能生成set方法
    /*public void setStr_key(String str_key){
        this.str_key=str_key;
    }*/

    public static void main(String[] args)throws Exception {

    }
    public void invoke_3( String req, Integer req2){
        FinalCommons commons=new FinalCommons();
        req="李四";
        req2=2;
    }
    //编译不通过
    /*public static void invoke_2(final String req,final Integer req2){
        req="李四";
        req2=2;
    }*/
    //https://www.cnblogs.com/fudashi/archive/2017/03/26/6624379.html
    public static void invoke_1() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<FinalCommons> clazz=FinalCommons.class;
        FinalCommons demo=clazz.newInstance();
        Field field=clazz.getDeclaredField("str_key");
        field.setAccessible(true);
        field.set(demo,"李四");
        System.out.println(field.get(demo));

        System.out.println(demo.getStr_key());
    }
}
