package com.java.designPattern.factory.func;

import com.java.designPattern.factory.Drink;

public class FactoryFuncTest {

    public static void main(String[] args){
        //用户必须知道要哪个工厂方法，怎么能让用户无感知呢？
        FactoryFunc factory=new RedTeaFactory();

        Drink redTea=factory.getDrink();

        System.out.println(redTea.getName());

        factory=new GreenTeaFactory();
        Drink greenTea=factory.getDrink();

        System.out.println(greenTea.getName());
    }
}
