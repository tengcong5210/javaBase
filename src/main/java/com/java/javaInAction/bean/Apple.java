package com.java.javaInAction.bean;

import java.io.Serializable;

/**
 * @创建人 tengcc
 * @创建时间 2019/4/22
 * @描述
 */
public class Apple implements Serializable {
    private static final long serialVersionUID = -5423529162559789832L;

    private String color;

    private Integer weight;

    public Apple(String color, Integer weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}