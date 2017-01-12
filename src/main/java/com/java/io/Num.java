package com.java.io;

import java.util.Scanner;

public class Num {

    public Num() {
    }

    static String[] bigNum = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };

    static String getNUM(String str) {

        int t = Integer.parseInt(str);
        return bigNum[t];
    }

    public static void main(String[] args) {
        try {
            String strbig = new String("");
            System.out.print("请输入数字：");
            Scanner sc = new Scanner(System.in);
            long num = sc.nextLong();
            String temp = String.valueOf(num);
            int b = temp.indexOf(".");
            int s = temp.length() - (b + 1);

            int j = b;
            for (int i = 0; i < b; i++) {
                strbig += getNUM(temp.substring(i, i + 1));

                j--;
            }
            temp = temp.substring(b + 1, temp.length());
            for (int i = 0; i < s; i++) {

                strbig += getNUM(temp.substring(i, i + 1));
            }
            System.out.println("转换结果：" + strbig);
        } catch (Exception ex) {
            System.out.println("请输入整数");
        }

    }
}
