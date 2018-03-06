package com.java.designPattern.factory.simple;

import com.java.designPattern.factory.Drink;
import com.java.designPattern.factory.RedTea;

/**
 * @author tengcongcong
 * @create 2018-03-06 18:22
 * @Version 1.0
 **/
public class SimpleFactoryTest {

    public static void main(String[] args){
        //自己生产红茶
        System.out.println(new RedTea().getName());

        SimpleFactory simpleFactory=new SimpleFactory();
        Drink drink=simpleFactory.getDrink("绿茶");
        System.out.println(drink.getName());
    }
}
