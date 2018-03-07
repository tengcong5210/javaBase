package com.java.designPattern.factory.func;

import com.java.designPattern.factory.Drink;

public interface FactoryFunc {
    /**
     * 生产饮料
     * @return
     */
    Drink getDrink();
}
