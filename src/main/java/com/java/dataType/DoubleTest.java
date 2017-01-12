package com.java.dataType;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class DoubleTest {
	private long value;
	
	@Test
	public void testLongConvertString() throws Exception {
		System.out.println("result:"+String.valueOf(value));
	}
	
	@Test
	public void testDoubleConvertString() throws Exception {
		double apr=0.0880;
		apr=apr*100;
		System.out.println("result:"+apr );
	}
	
	/**
	 * 校验申请金额
	 * @param applyMoney
	 * @return
	 */
	@Test
	public void checkApplyMoney()throws Exception {
		Double applyMoney=Double.valueOf("0");
		boolean bool=false;
		BigDecimal money=BigDecimal.valueOf(applyMoney).setScale(2, BigDecimal.ROUND_HALF_UP);
		if(money.compareTo(new BigDecimal("99999999.99"))==1){
			bool=true;
		}
		if(money.compareTo(BigDecimal.ZERO)<0){
			bool=true;
		}
		System.out.println(bool);
	}
	
}
