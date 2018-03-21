package com.java.designPattern.factory.func;

import com.java.designPattern.factory.Drink;
import com.java.designPattern.factory.RedTea;

public class RedTeaFactory implements FactoryFunc {
    public Drink getDrink() {
        return new RedTea();
    }
}
