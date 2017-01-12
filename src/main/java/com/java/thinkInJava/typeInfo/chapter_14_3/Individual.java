package com.java.thinkInJava.typeInfo.chapter_14_3;

/**
 * 类Individual.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月14日 上午11:36:21
 * @version 1.0.0
 */
public class Individual {
    private Integer id;
    private String  name;

    public Individual() {

    }

    public Individual(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return this.id + "," + this.name;
    }
}
