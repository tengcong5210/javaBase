package com.java.bean.DTO;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ibm on 2017/5/28.
 */
public class ExcelParseResultDTO implements Serializable {

    private static final long serialVersionUID = -8353148566901299549L;
    private String id;
    private String name;
    private String age;
    private String salary;
    private Date dateOnBoard;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Date getDateOnBoard() {
        return dateOnBoard;
    }

    public void setDateOnBoard(Date dateOnBoard) {
        this.dateOnBoard = dateOnBoard;
    }
}
