package com.java.tool;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.apache.commons.lang.StringUtils;

/**
 * 字符串格式数字计算工具
 * 
 * @author shihuaizhou
 */
public class MoneyTool {

    /**
     * 对两个字符串做减法（不丢失精度）
     * 
     * @param src 被减数
     * @param dest 减数
     * @return String
     */
    public static String subtract(String src, String dest) {
        BigDecimal srcDeci = new BigDecimal(src);
        BigDecimal desctDeci = new BigDecimal(dest);
        return String.valueOf(srcDeci.subtract(desctDeci));
    }

    /**
     * 对两个字符串做加法（不丢失精度）
     * 
     * @param src
     * @param dest
     * @return String
     */
    public static String add(String src, String dest) {
        BigDecimal srcDeci = new BigDecimal(src);
        BigDecimal desctDeci = new BigDecimal(dest);
        return String.valueOf(srcDeci.add(desctDeci));
    }

    public static BigDecimal addBigDecimal(String src, String dest) {
        BigDecimal srcDeci = new BigDecimal(src);
        BigDecimal desctDeci = new BigDecimal(dest);
        return srcDeci.add(desctDeci);
    }

    private static final String ZERO_AMOUNT = "0.00";

    /**
     * 方法说明 （创建于 2014-6-10）. 描述：BIG转String 可以控制精度四舍五入
     * 
     * @param bd
     * @param w 精度
     * @return
     * @returnType String
     * @see com.zhongan.core.cfthl.service.impl#FacadeServiceImpl
     */
    public static String bigDecimalToString(BigDecimal bd, int w) {
        return ((new BigDecimal(ZERO_AMOUNT)).add(bd)).setScale(w, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 比较传入字符串与0
     * 
     * @param src
     * @return 0 相等，1 大于0, -1 小于0
     */
    public static int compareToZero(String src) {
        return new BigDecimal(src).compareTo(BigDecimal.ZERO);
    }

    /**
     * 计算出“分”单位的Long类型
     * 
     * @param bd
     * @return
     */
    public static Long convertToFenLg(BigDecimal bd) {
        BigDecimal fenBd = bd.multiply(new BigDecimal("100.0"));
        fenBd.setScale(0, BigDecimal.ROUND_HALF_UP);
        return fenBd.longValue();
    }

    /**
     * 金额取反
     * 
     * @param src
     * @return 负数返回正数，正数返回负数
     */
    public static String negate(String src) {
        return new BigDecimal(src).negate().toString();
    }

    /**
     * 字符串金额大小比较
     * 
     * @param src
     * @param dest
     * @return src在数字上小于、等于或大于 dest 时，返回 -1、0 或 1
     */
    public static int compare(String src, String dest) {
        BigDecimal srcDeci = new BigDecimal(src);
        BigDecimal destDeci = new BigDecimal(dest);
        return srcDeci.compareTo(destDeci);
    }

    /**
     * 对两个字符串做乘法（不丢失精度）
     * 
     * @param src
     * @param dest
     * @return
     */
    public static String multiply(String src, String dest) {
        BigDecimal srcDeci = new BigDecimal(src);
        BigDecimal destDeci = new BigDecimal(dest);

        return srcDeci.multiply(destDeci).toString();
    }

    /**
     * 分为单位的数字转换为元
     * 
     * @param fenStr
     * @return
     */
    public static String fen2Yuan(String fenStr) {
        if (StringUtils.isBlank(fenStr)) {
            return fenStr;
        }
        return new BigDecimal(fenStr).divide(new BigDecimal("100.0")).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 以元为单位的数字转换为分
     * 
     * @param yuanStr
     * @return
     */
    public static String yuan2Fen(String yuanStr) {
        if (StringUtils.isBlank(yuanStr)) {
            return yuanStr;
        }
        return new BigDecimal(yuanStr).multiply(new BigDecimal("100.0")).setScale(0, BigDecimal.ROUND_HALF_UP)
                .toString();
    }

    /**
     * 集成乘法和除法计算，默认保持4位精度，四舍五入
     * 
     * @param src 不支持 xxx/xx格式
     * @param dest 支持 xxx/xx格式 支持多个参数
     * @return string
     */
    public static String integration(String src, String... dest) {
        BigDecimal srcDeci = new BigDecimal(src);
        for (String temp : dest) {
            if (temp.indexOf("/") != -1) {
                String[] temps = temp.split("/");
                srcDeci = srcDeci.multiply(new BigDecimal(temps[0]));
                srcDeci = srcDeci.divide(new BigDecimal(temps[1]), 4, RoundingMode.HALF_UP);
            } else {
                srcDeci = srcDeci.multiply(new BigDecimal(temp));
            }
        }

        return srcDeci.setScale(4, RoundingMode.HALF_UP).toString();
    }

    /**
     * 集成乘法和除法计算,四舍五入 param scale 保留小数精度
     * 
     * @param src 不支持 xxx/xx格式
     * @param dest 支持 xxx/xx格式 支持多个参数
     * @return string
     */
    public static String integration(int scale, String src, String... dest) {
        BigDecimal srcDeci = new BigDecimal(src);
        for (String temp : dest) {
            if (temp.indexOf("/") != -1) {
                String[] temps = temp.split("/");
                srcDeci = srcDeci.multiply(new BigDecimal(temps[0]));
                srcDeci = srcDeci.divide(new BigDecimal(temps[1]), scale, RoundingMode.HALF_UP);
            } else {
                srcDeci = srcDeci.multiply(new BigDecimal(temp));
            }
        }

        return srcDeci.setScale(scale, RoundingMode.HALF_UP).toString();
    }

    /**
     * 对两个字符串做乘法，根据精度进行四舍五入
     * 
     * @param src
     * @param dest
     * @param scale
     * @return
     */
    public static String multiply(String src, String dest, int scale) {
        BigDecimal srcDeci = new BigDecimal(src);
        BigDecimal destDeci = new BigDecimal(dest);
        return srcDeci.multiply(destDeci).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 对两个字符串做除法（不丢失精度）
     * 
     * @param src
     * @param dest
     */
    public static String divide(String src, String dest) {
        BigDecimal srcDeci = new BigDecimal(src);
        BigDecimal destDeci = new BigDecimal(dest);
        return String.valueOf(srcDeci.divide(destDeci));
    }

    /**
     * 对两个字符串做除法（不丢失精度），四舍五入保留指定位数的小数
     * 
     * @param src
     * @param dest
     * @param scale 保留位数
     */
    public static String divide(String src, String dest, int scale) {
        BigDecimal srcDeci = new BigDecimal(src);
        BigDecimal destDeci = new BigDecimal(dest);
        return srcDeci.divide(destDeci, scale, RoundingMode.HALF_UP).toString();
    }

    /**
     * 支持较为简单的多级运算 ，默认四舍五入
     * 
     * @param map 传入的参数值
     * @param script 运算表达式，如:A+B*(C+D)/2
     * @param scale 精度，返回结果的精度
     * @return
     */
    //    public static String numericalComputation(Map<String, BigDecimal> map, String script, int scale) throws Exception {
    //        //        ScriptEngineManager manager = new ScriptEngineManager();
    //        //        ScriptEngine engine = manager.getEngineByName("javascript");
    //        //        for (Map.Entry<String, Object> m : map.entrySet()) {
    //        //            if (null == m.getValue()) {
    //        //                logger.error("请检查参数" + m.getKey() + "的值是否为空!map:" + map.toString());
    //        //                throw new Exception("请检查参数" + m.getKey() + "的值是否为空!map:" + map.toString());
    //        //            }
    //        //            engine.put(m.getKey(), Double.parseDouble(m.getValue().toString()));
    //        //        }
    //        //        String value = null;
    //        //        try {
    //        //            value = engine.eval(script).toString();
    //        //        } catch (ScriptException e) {
    //        //            logger.error("请检查参数的值是否为空!map:" + map.toString() + ",script:" + script + ",message:" + e.getMessage(), e);
    //        //            throw new Exception("请检查参数的值是否为空!map:" + map.toString() + ",script:" + script + ",message:"
    //        //                    + e.getMessage(), e);
    //        //        }
    //
    //        Expression expn = new Expression(script);
    //        BigDecimal srcDeci = expn.eval(map);
    //
    //        return srcDeci.setScale(scale, RoundingMode.HALF_UP).toString();
    //    }

    /**
     * 截取到毫
     * 
     * @param src
     * @return
     */
    public static String roundHao(String src) {
        return new BigDecimal(src).setScale(4, RoundingMode.DOWN).toString();
        // String i = String.valueOf(new BigDecimal(MoneyTool.multiply(src,
        // "10000")).longValue());
        // return divide(i, "10000");
    }
    public static String formatCurrencyNotMinimum(double d) {
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
    public static void main(String[] args) throws FileNotFoundException, IOException {
//        String premium = "-112.50";
//        String sumAmount = "75";
//        String uwPremium = subtract(premium, sumAmount);//批改后的保费值
//        System.out.println("uwPremium:" + uwPremium);
//        String changeValue = subtract(uwPremium, premium);
//        System.out.println("changeValue:" + changeValue);
//        ;
//        System.out.println(new BigDecimal(premium).abs().toString());
    	
    	double d=1000000000;
    	System.out.println("aa="+formatCurrencyNotMinimum(d));

    }
}
