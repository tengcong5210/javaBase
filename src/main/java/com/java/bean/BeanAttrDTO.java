package com.java.bean;

/**
 * @author tengcongcong
 * @create 2017-07-13 14:17
 * @Version 1.0
 **/
public class BeanAttrDTO {

    private String proName;
    private String proKey;
    private String proValue;

    public BeanAttrDTO(){

    }

    public BeanAttrDTO(String proName,String proKey,String proValue){
        this.proName=proName;
        this.proKey=proKey;
        this.proValue=proValue;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProKey() {
        return proKey;
    }

    public void setProKey(String proKey) {
        this.proKey = proKey;
    }

    public String getProValue() {
        return proValue;
    }

    public void setProValue(String proValue) {
        this.proValue = proValue;
    }
}
