package com.java.json.bean;

import java.io.Serializable;

public class LoanApply implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 832340942882950172L;
    private String            applyNo;
    private String            amount;
    //
    private String proType;
    private String proName;
    private String proKey;


    public LoanApply(String applyNo, String amount) {
        super();
        this.applyNo = applyNo;
        this.amount = amount;
    }

    public LoanApply() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getProType() {
        return proType;
    }

    public void setProType(String proType) {
        this.proType = proType;
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
}
