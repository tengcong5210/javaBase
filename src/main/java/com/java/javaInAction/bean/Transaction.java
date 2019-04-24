package com.java.javaInAction.bean;

import java.io.Serializable;

/**
 *
 * @创建人 tengcc
 * @创建时间 2019/4/24
 * @描述
 */
public class Transaction implements Serializable {
    private static final long serialVersionUID = -1309125278149624049L;

    private int price;
    private String currency;

    public Transaction(int price, String currency) {
        this.price = price;
        this.currency = currency;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}