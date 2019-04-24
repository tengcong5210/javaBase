package com.java.javaInAction;

import java.io.Serializable;

/**
 * @创建人 tengcc
 * @创建时间 2019/4/22
 * @描述
 */
public class Apple implements Serializable {
    private static final long serialVersionUID = -5423529162559789832L;

    private String color;

    private int weight;

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}