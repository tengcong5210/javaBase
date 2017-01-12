package com.java.json.bean;

import java.io.Serializable;

public class LoanApply implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 832340942882950172L;
    private String            applyNo;
    private String            amount;

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

}
