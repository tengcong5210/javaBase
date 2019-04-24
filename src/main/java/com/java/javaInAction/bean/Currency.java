package com.java.javaInAction.bean;

import java.io.Serializable;

/**
 * @创建人 tengcc
 * @创建时间 2019/4/24
 * @描述
 */
public class Currency implements Serializable {
    private static final long serialVersionUID = -2967014709507196034L;

    private String code;
    private String name;

    public Currency(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}