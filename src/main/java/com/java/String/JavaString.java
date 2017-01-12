package com.java.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class JavaString {
    private static Class c;

    public JavaString() {
        this.c = getClass();
        System.out.println("构造函数：" + c.getName());
    }

    /**
     * indexOf 使用
     */
    public static void indexOfTest(String param) {
        int i = param.indexOf('}', 1);
        System.out.println("i:" + i);
    }

    public static String[] splitTaskItem(String str) {
        List<String> list = new ArrayList<String>();
        int start = 0;
        int index = 0;
        while (index < str.length()) {
            if (str.charAt(index) == ':') {
                index = str.indexOf('}', index) + 1;
                list.add(str.substring(start, index).trim());
                while (index < str.length()) {
                    if (str.charAt(index) == ' ') {
                        index = index + 1;
                    } else {
                        break;
                    }
                }
                index = index + 1;
                start = index;
            } else if (str.charAt(index) == ',') {
                list.add(str.substring(start, index).trim());
                while (index < str.length()) {
                    if (str.charAt(index) == ' ') {
                        index = index + 1;
                    } else {
                        break;
                    }
                }
                index = index + 1;
                start = index;
            } else {
                index = index + 1;
            }
        }
        if (start < str.length()) {
            list.add(str.substring(start).trim());
        }
        return (String[]) list.toArray(new String[0]);
    }

    /**
     * UUID是1.5中新增的一个类，在java.util下，用它可以产生一个号称全球唯一的ID
     */
    public static void uuidTest() {
        UUID uuid = UUID.randomUUID();
        System.out.println("aa:" + uuid);
    }

    /**
     * 拆分案例
     * 
     * @param fileNameStartWith 如:LoanRequest;11
     */
    public static void fileNameSubstring(String fileNameStartWith) {
        //        String fileNameStartWith = it.next(); 
        String specThirdCode = "";
        System.out.println("fileNameStartWith before=" + fileNameStartWith);
        if (fileNameStartWith.contains(";")) {
            specThirdCode = fileNameStartWith.substring(fileNameStartWith.lastIndexOf(";") + 1);
            fileNameStartWith = fileNameStartWith.substring(0, fileNameStartWith.lastIndexOf(";"));
            System.out.println("specThirdCode=" + specThirdCode);
            System.out.println("fileNameStartWith end=" + fileNameStartWith);
        }
    }

    public static void main(String[] args) {
        String str = "0:{sex=0},1:{sex=1}";
        indexOfTest(str);
        String[] array = splitTaskItem(str);//[0:{sex=0}, 1:{sex=1}]
        System.out.println(Arrays.asList(array));

        //        uuidTest();

        //        try {
        //            BigDecimal big = new BigDecimal("331.73");
        //
        //            long a = big.longValue();
        //            System.out.println("aa:" + a);
        //        } catch (Exception e) {
        //            e.printStackTrace();
        //        }
        //
        //        String fileNameStartWith = "LoanRequest;11";
        //        fileNameSubstring(fileNameStartWith);
        //
        //        String crlf = System.getProperty("line.separator");
        //        System.out.println("crlf:" + crlf);

        String rep = "gmt_modified,creator,audit_reason,third_code,,currency,apply_date,,inner_Message,,,premium,id,,loan_apply_no,,,extra_info,,loan_type,,,audit_date,,loan_period,is_repeat_audit,gmt_created,actual_amount,,,loan_way,loan_period_number,,requirement_no,,inner_Code,,third_user_no,,,outter_Code,amount_invalid_date,every_period_repay,,apply_amount,is_deleted,,product_id,,user_id,outter_Message,,channel_id,,amount,,repeat_audit_status,loan_status,modifier";
        System.out.println(rep.replace(" ", ","));

    }
}
