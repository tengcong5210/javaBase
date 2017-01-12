package com.java.String;

import org.apache.commons.lang.StringUtils;

/**
 * commons-lang包字符串操作
 * 
 * @author linco lee
 */
public class CommonLangString {
    /**
     * 将给定的字符串首字母大写
     * 
     * @param propertyName
     * @return
     */
    public static String capitalize(String propertyName) {
        return StringUtils.capitalize(propertyName);
    }

    public static void main(String[] args) {
        String propertyName = null;
        String str = "get" + capitalize(propertyName);
        System.out.println("str:" + str);
    }
}
