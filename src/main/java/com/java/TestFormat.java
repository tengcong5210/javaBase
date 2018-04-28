package com.java;

import com.java.tool.IdcardInfoExtractor;
import org.junit.Test;

public class TestFormat {
    @Test
    public void testRun(){
        String str="1111|2222|3333|4444";
        String[] arry=str.split("\\|");
        System.out.println("length:"+arry.length+";length-2:"+(arry.length-2));
        for (int i=arry.length-2;i>=0;i--){
            System.out.println("dddd:"+arry[i]);
        }
    }

    @Test
    public void testIdcardInfoExtractor(){
        String idcard = "310106199406022516";
        IdcardInfoExtractor ie = new IdcardInfoExtractor(idcard);
        System.out.println(ie.toString());
    }

    /**
     * 字符串去除空格
     */
    @Test
    public void testRepalce(){
        String str = "[0,   0.25  )";
        System.out.println(str.replaceAll("\\s",""));
    }
}
