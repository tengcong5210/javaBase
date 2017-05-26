package com.java.json.EnumSerialize;

/**
 * 投资期限利率枚举
 * @author tengcongcong
 *
 */
public enum InvestTermRateEnum {
	
	MONTH_05("0.5","6","0.5个月"),
	MONTH_1("1","6.5","1个月"),
	MONTH_2("2","7","2个月"),
	MONTH_3("3","8","3个月"),
	MONTH_4("4","8.3","4个月"),
	MONTH_5("5","8.5","5个月"),
	MONTH_6("6","8.5","6个月"),
	MONTH_12("12","9.3","12个月"),
	;
	
	private String month;
	private String rate;
	private String desc;
	
	private InvestTermRateEnum(String month,String rate,String desc){
		this.month=month;
		this.rate=rate;
		this.desc=desc;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
}
