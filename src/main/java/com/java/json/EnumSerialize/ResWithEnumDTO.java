package com.java.json.EnumSerialize;

import java.io.Serializable;

/**
 * @author tengcongcong
 * @create 2017-05-26 9:09
 * @Version 1.0
 **/
public class ResWithEnumDTO implements Serializable {
    private static final long serialVersionUID = 2748265644975526438L;

    private Integer id;
    private InvestTermRateEnum termRateEnum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public InvestTermRateEnum getTermRateEnum() {
        return termRateEnum;
    }

    public void setTermRateEnum(InvestTermRateEnum termRateEnum) {
        this.termRateEnum = termRateEnum;
    }
}
