package com.java.designPattern.factory.func;

import com.java.designPattern.factory.Coffee;
import com.java.designPattern.factory.Drink;

public class CoffeeFactory implements FactoryFunc {

    public Drink getDrink() {
        return new Coffee();
    }
}
