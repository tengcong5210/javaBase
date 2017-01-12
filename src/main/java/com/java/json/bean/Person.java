package com.java.json.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Person implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 8330128061576349932L;

    public Person() {
        super();
    }

    public Person(String name, Integer age, String phone, Date birthday, List<Person> faimlies) {
        super();
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.birthday = birthday;
        this.faimlies = faimlies;
    }

    private String       name;
    private Integer      age;
    private String       phone;
    private Date         birthday;
    private List<Person> faimlies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Person> getFaimlies() {
        return faimlies;
    }

    public void setFaimlies(List<Person> faimlies) {
        this.faimlies = faimlies;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", phone=" + phone + ", birthday=" + birthday + ", faimlies="
                + faimlies + "]";
    }

}
