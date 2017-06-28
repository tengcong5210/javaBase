package com.java.bean;

import java.io.Serializable;
import java.util.List;

/**
 * excel文件解析结果
 * Created by ibm on 2017/5/28.
 */
public class FileParseResult<T> implements Serializable {

    private static final long serialVersionUID = -2333006267404407156L;
    /**
     * 错误描述
     */
    private String            errorDesc;

    /**
     * 解析结果集
     */
    private List<T> resultList;

    /**
     * 如为false，则表示读取文件时就报错
     */
    private Boolean           success          = false;

    /**
     * 文件总记录数
     */
    private int               total;

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
