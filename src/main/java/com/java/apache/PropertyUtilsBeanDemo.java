package com.java.apache;

import org.apache.commons.beanutils.PropertyUtilsBean;

/**
 * 类PropertyUtilsBeanDemo.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年11月26日 下午6:12:57
 * @version 1.0.0
 */
public class PropertyUtilsBeanDemo {
    public static void main(String[] args) throws Exception {
        PropertyUtilsBean bean = new PropertyUtilsBean();
        Object refObj = "29022015059122900003";
        String tradeNo = (String) bean.getProperty(refObj, "loanApplyNo");
        System.out.println(tradeNo);
    }
}
