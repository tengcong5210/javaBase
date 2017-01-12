package com.java.String;

/**
 * String类练习
 * 
 * @author tengcongcong
 * @date 2015年12月2日 上午9:51:31
 * @version 1.0.0
 */
public class StringExerciseDemo {
    /**
     * 练习一:去除字符串头、尾的空格
     * 
     * @param arg
     * @return
     */
    public static String trim(String arg) {
        int start = 0, end = arg.length() - 1;
        //从头检查每一个字符是否是空字符.
        while (start <= end && arg.charAt(start) == ' ') {
            start++;
        }
        System.out.println("start:" + start + ";end:" + end);
        while (start <= end && arg.charAt(end) == ' ') {
            end--;
        }
        System.out.println("start:" + start + ";end:" + end);
        return arg.substring(start, end + 1);
    }

    /**
     * 练习二：计算key在str中出现的次数
     * 
     * @param str 原字符串 "abddefddgkyngxdd"
     * @param key 要查找的字符串 "dd"
     */
    public static void countStr(String str, String key) {

        int count = 0;
        int index = 0;

        //方式一：
        //        while ((index = str.indexOf(key)) != -1) {
        //            str = str.substring(index + key.length());
        //            System.out.println("str:" + str);
        //            count++;
        //        }

        //方式二:
        while ((index = str.indexOf(key, index)) != -1) {
            System.out.println("index:" + index);
            str = str.substring(key.length() + index);
            System.out.println("str:" + str);
            count++;
        }

        System.out.println("count:" + count);

    }

    public static void main(String[] args) {
        //        String str = "   dddd aaa   ";
        //        System.out.println(trim(str));

        String str = "abddefddgkyngxdd";
        String key = "dd";
        countStr(str, key);
    }
}
