package com.java.dataType;

public class NumberCheck {
    public static boolean isNumber(String str) {
        //        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("[0-9]*");数字
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("^(\\-|\\+)?\\d+(\\.\\d+)?$");//正数、负数、小数
        java.util.regex.Matcher match = pattern.matcher(str);
        if (match.matches() == false) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        boolean bool = NumberCheck.isNumber("a2345678");
        System.out.println("bool:" + bool);
    }
}
