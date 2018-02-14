package com.java.genericity;

/**
 * @author tengcongcong
 * @create 2018-02-14 13:46
 * @Version 1.0
 **/
public class GenericityTest {

    public static void main(String[] args){
        System.out.println("*********泛型类测试***********");
        Box<Integer>  integerBox=new Box<Integer>();
        integerBox.setData(1);
        Box<String> stringBox=new Box<String>();
        stringBox.setData("xxx");
        System.out.println("*********泛型类测试***********结束");
    }
}
