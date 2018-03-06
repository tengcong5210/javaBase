package com.java.designPattern.factory.simple;

import com.java.designPattern.factory.Coffee;
import com.java.designPattern.factory.Drink;
import com.java.designPattern.factory.GreenTea;
import com.java.designPattern.factory.RedTea;

/**
 * @author tengcongcong
 * @create 2018-03-06 18:21
 * @Version 1.0
 **/
public class SimpleFactory {
   public Drink getDrink(String name){
       if("红茶".equals(name)){
           return new RedTea();
       }else if("绿茶".equals(name)){
           return new GreenTea();
       }else if("咖啡".equals(name)){
           return new Coffee();
       }
       return null;
   }
}
