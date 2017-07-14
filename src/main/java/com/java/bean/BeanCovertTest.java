package com.java.bean;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tengcongcong
 * @create 2017-07-13 14:20
 * @Version 1.0
 **/
public class BeanCovertTest {
    @Test
    public void testBeanAttrDTOToJavaBean(){
        List<BeanAttrDTO> list=new ArrayList<BeanAttrDTO>();
        list.add(new BeanAttrDTO("当期期数","loanPeriod","1"));
        list.add(new BeanAttrDTO("原始应还本金","origPrincipalBal","10000"));
        list.add(new BeanAttrDTO("实还本金","repayedPrincipalBal","60000"));



    }

}
