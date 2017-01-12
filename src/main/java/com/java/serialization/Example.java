package com.java.serialization;

import java.io.Serializable;

public class Example implements Serializable {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    private String            name;
    private int               id;
    transient private int     salary;

    @Override
    public String toString() {
        return "Example{name=" + name + ",id=" + id + ",salary=" + salary + "}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
