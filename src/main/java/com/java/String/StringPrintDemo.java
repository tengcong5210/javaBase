package com.java.String;

/**
 * 类StringPrintDemo.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年10月26日 上午6:51:41
 * @version 1.0.0
 */
public class StringPrintDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int x = 6;
        double y = 22.4567;
        System.out.println("Row 1:[" + x + " " + y + "]");
        System.out.format("Row 1:[%d %f]\n", x, y);
        System.out.format("Row 2:%d %f \n", x, y);
        System.out.printf("Row 3:[%d %f]\n", x, y);
        
        String tel="18616231631";
        System.out.println(tel.substring(tel.length()-6));
    }

}
