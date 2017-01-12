package com.java.dataType;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;


public class BigdcimalTest {

	private static final String WANYUAN="万元";
	private static final String YUAN="元";
    /**
     * string 类型金额转BigDecimal
     */
    @Test
    public void stringConvertBigDecimal() {
        String amount = "1200.066";
        BigDecimal bigAmount = new BigDecimal(amount);
        bigAmount = bigAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println("int:" + bigAmount.intValue());
        System.out.println(bigAmount.toString());
    }

    /**
     * BigDicemal类型判断是否大于零 当此 BigDecimal 在数字上小于、等于或大于 val 时，返回 -1、0 或 1。
     */
    @Test
    public void compareDate() {
        String amount = "-0.001";
        BigDecimal bigAmount = new BigDecimal(amount);
        //        bigAmount = bigAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println("compareResult:" + bigAmount.compareTo(BigDecimal.ZERO));
        if (bigAmount.compareTo(BigDecimal.ZERO) == 1) {
            System.out.println("大于零");
        } else if (bigAmount.compareTo(BigDecimal.ZERO) == 0) {
            System.out.println("等于零");
        } else if (bigAmount.compareTo(BigDecimal.ZERO) == -1) {
            System.out.println("小于零");
        }
    }

    /**
     * 将null直接转bigdecimal会怎样 对String 类型的转bigdecimal 抓 先判string是否为空
     */
    @Test
    public void nullBigdecimal() {
        //        String str = null;
        String str = "";
        BigDecimal bigNull = new BigDecimal(str);
        System.out.println(bigNull);
    }

    @Test
    public void testCompare() throws Exception {
        String payment_money = "5";
        String yearDay = "360";
        String loanlimit = "63";
        String dyrate = "0.02";

        BigDecimal bd1 = new BigDecimal(payment_money).divide(new BigDecimal(dyrate), 10, BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal(yearDay)).divide(new BigDecimal(loanlimit), 10, BigDecimal.ROUND_HALF_UP);
        System.out.println("result:" + bd1);

        BigDecimal bd2 = new BigDecimal(payment_money).multiply(new BigDecimal(yearDay)).divide(
                new BigDecimal(dyrate).multiply(new BigDecimal(loanlimit)), 10, BigDecimal.ROUND_HALF_UP);
        System.out.println("result:" + bd2);

        BigDecimal bd3 = new BigDecimal(payment_money).multiply(new BigDecimal(yearDay))
                .divide(new BigDecimal(dyrate), 10, BigDecimal.ROUND_HALF_UP)
                .divide(new BigDecimal(loanlimit), 10, BigDecimal.ROUND_HALF_UP);
        System.out.println("result:" + bd3);

    }

    @Test
    public void testBigMoney() throws Exception {

        NumberFormat nf = new DecimalFormat(",##0.00");
        String formatMoney = nf.format(100000000.00);
        System.out.println(formatMoney);

        NumberFormat nf2 = NumberFormat.getInstance();
        double aa = (Double) nf2.parse("6645,4456.001");
        System.out.println(aa);

    }

    @Test
    public void testBig() throws Exception {
        String start = "10000";
        String end = "10000";
        String s = new BigDecimal(start).remainder(new BigDecimal(end)).compareTo(BigDecimal.ZERO) == 0 ? "万元" : "元";
        System.out.println(new BigDecimal(start).remainder(new BigDecimal(end)) + ";s=" + s);

        BigDecimal a1 = new BigDecimal("340050");
        BigDecimal a2 = new BigDecimal("10000");
        System.out.println("aa=" + a1.divide(a2) + s);

    }

    /**
     * 获取债权格式化后的金额
     * 
     * @param claimsAmount
     * @return
     */
    @Test
    public void getClaimAmount() {
        String claimsAmountStr = "-100000";
        BigDecimal claimsAmount = StringUtils.isBlank(claimsAmountStr) ? new BigDecimal("0.00") : new BigDecimal(
                claimsAmountStr);
        BigDecimal mod = new BigDecimal("10000");
        //    如果大于1000要以万元为单位 且是10000的整数倍
        if (claimsAmount.compareTo(BigDecimal.ZERO) == 1 && claimsAmount.remainder(mod).compareTo(BigDecimal.ZERO) == 0) {
            claimsAmountStr = formatCurrencyNotMinimum(claimsAmount.divide(mod).doubleValue());

        }
        String unit = getClaimLoanAmountUnit(claimsAmount, mod);
        System.out.println(claimsAmountStr + unit);
    }
    /**
     * 债转总额 格式化
     * @throws Exception
     */
    @Test
	public void testTransPrice() throws Exception {
    	String price="10000";
    	String unit="元";
    	BigDecimal amount=new BigDecimal(price);
        BigDecimal mod = new BigDecimal("10000");
        if (amount.compareTo(BigDecimal.ZERO) == 1 && amount.remainder(mod).compareTo(BigDecimal.ZERO) == 0) {
        	price=amount.divide(mod).toString();
        	unit="万元";
        }
        price=price+unit;
        System.out.println("price="+price);
	}
    @Test
    public void testNumberFormat() {
    	BigDecimal bd=new BigDecimal("3.0");
    	String formats="######0.00";
		if (bd == null || "0".equals(bd.toString())) {
			System.out.println("00000000000");
		}

		DecimalFormat bf = new DecimalFormat(formats);
		System.out.println(bf.format(bd)) ;
	}
    /**
     * 小数 扩大100倍
     */
    @Test
    public  void testMul() {
    	double v1=0.0050;
    	double v2=100;
		BigDecimal b1 = new BigDecimal(Double.toString(v1));

		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		System.out.println("小数 扩大100倍:"+b1.multiply(b2).doubleValue());

	}
    
    @Test
	public void testSubtract() throws Exception {
    	String fairValue ="10079.70" ;//公允价值
        String discountPrice = "0";//折让金额
        String price = new BigDecimal(fairValue).subtract(new BigDecimal(discountPrice)).toString();
        String price2=formatCurrencyNotMinimum(Double.valueOf(price));
        price=formatCurrency(Double.valueOf(price));
        System.out.println("price="+price);
        System.out.println("price2="+price2);
	}
    
    
    /**
     *  测试String 类型转double 注意2.20 转double后 会不会保留两位小数
     * @throws Exception
     */
    @Test
	public void testStringConvertDouble() throws Exception {
    	String price="2.20";
    	double value1=Double.valueOf(price);
    	double value2=Double.parseDouble(price);
    	System.out.println("value1="+value1+";value2="+value2);
    	
	}
    /**
     * 测试49999 换算成万元
     * @throws Exception
     */
    @Test
	public void test49999() throws Exception {
		BigDecimal loanAmount=new BigDecimal("49999.00");
		BigDecimal mod=new BigDecimal("10000.00");
		System.out.println("bigdecimal除以后转double:"+this.formatCurrency(loanAmount.divide(mod).doubleValue()));
		
	}
    
    /**
     * 金额单位测试  如果金额是万的整数倍则显示xx万元;如果金额是1000的倍数，则显示xx.x万元;否则 显示 xxx.xx元
     * 
     * @throws Exception
     */
    @Test
	public void testAmountMyriadUnit() throws Exception {
    	BigDecimal loanAmount=new BigDecimal("4899000.00");
    	String result=fromatAmountUnit(loanAmount);
    	System.out.println("result:"+result);
	}
    /**
     * 格式化金额 带单位 元Or万元
     * @param amount 要转换的金额
     * @param mod  转换的基数  比如：10000
     */
	private String fromatAmountUnit(BigDecimal amount) {
		String amountUnit="";
		if(null==amount){
			System.out.println("amount or mod is null");
			return amountUnit;
		}
		BigDecimal mod=new BigDecimal("10000.00");
		BigDecimal mod1=new BigDecimal("1000.00");
		try {
			if (amount.compareTo(BigDecimal.ZERO) == 1 && (amount.remainder(mod).compareTo(BigDecimal.ZERO) == 0||amount.remainder(mod1).compareTo(BigDecimal.ZERO) == 0)) {
	    		amountUnit=formatCurrencyNotMinimum(amount.divide(mod).doubleValue());//格式化金额  不保留两位小数
	    		return amountUnit+"万元";
	    	}
	    	amountUnit=formatCurrency(Double.valueOf(amount.doubleValue()))+"元";//格式化金额   要保留两位小数
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return amountUnit;
	}
    
    private String getClaimLoanAmountUnit(BigDecimal loan_amount, BigDecimal mod) {
        if (loan_amount.compareTo(BigDecimal.ZERO) == 0) {
            return "元";
        }
        return loan_amount.remainder(mod).compareTo(BigDecimal.ZERO) == 0 ? "万元" : "元";
    }
    
    
    
    /**
   	 * 使用默认方式显示货币： 例如:￥12,345.46  此方式 10079.70 值 不会保留两位小数
   	 * 
   	 * @param d
   	 *            double
   	 * @return String
   	 */
    private String formatCurrencyNotMinimum(double d) {
        String s = "";
        try {
            DecimalFormat nf = new DecimalFormat();
            nf.setRoundingMode(RoundingMode.HALF_UP);
            if (d > 0) {
                s = nf.format(d);
            } else {
                s = "0";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
    /**
	 * 使用默认方式显示货币： 例如:￥12,345.46 默认保留2位小数，四舍五入
	 * 
	 * @param d
	 *            double
	 * @return String
	 */
	private String formatCurrency(double d) {
		String s = "";
		try {
			DecimalFormat nf = new DecimalFormat();
			nf.setRoundingMode(RoundingMode.HALF_UP);
			nf.setMinimumFractionDigits(2);
			if (d > 0) {
				s = nf.format(d);
			} else {
				s = "0.00";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s.replace(".00", "");
	}
	
	/**
	 * 格式化金额去除无效零 .00 去掉  如果是45.90 要保留两位小数
	 * @param d
	 * @return
	 */
	private  String formatAmountWithoutZero(double d) {
		String s = "";
		try {
			DecimalFormat nf = new DecimalFormat();
			nf.setRoundingMode(RoundingMode.HALF_UP);
			nf.setMinimumFractionDigits(2);
			if (d > 0) {
				s = nf.format(d);
			} else {
				s = "0.00";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s.replace(".00", "");
	}
	
	@Test
	public void testDoubleRound() throws Exception {
		BigDecimal rate=new BigDecimal("0.00003");
		double res=rate.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println("res:"+res);
	}
}
