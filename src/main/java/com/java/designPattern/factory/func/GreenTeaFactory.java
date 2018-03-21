package com.java.designPattern.factory.func;

import com.java.designPattern.factory.Drink;
import com.java.designPattern.factory.GreenTea;

public class GreenTeaFactory implements FactoryFunc {
    public Drink getDrink() {
        return new GreenTea();
    }
}
