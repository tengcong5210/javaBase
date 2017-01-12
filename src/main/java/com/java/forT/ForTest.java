package com.java.forT;

import java.util.ArrayList;
import java.util.List;

public class ForTest {

    public static void testFor() {
        int x;
        for (x = 1; x <= 10; x++)
            ;
        {
            System.out.println(x);
        }
        System.out.println("结束");
    }

    public static void testFor1() {
        int v1 = 10000;
        int v2 = 100;
        int v3 = 10;
        long l1 = System.currentTimeMillis();
        for (int i = 0; i <= v1; i++) {
            for (int j = 0; j <= v2; j++) {
                for (int k = 0; k <= v3; k++) {
                    System.out.println("方式一");
                }
            }
        }
        long l2 = System.currentTimeMillis();
        for (int i = 0; i <= v3; i++) {
            for (int j = 0; j <= v2; j++) {
                for (int k = 0; k <= v1; k++) {
                    System.out.println("方式二");
                }
            }
        }
        long l3 = System.currentTimeMillis();
        System.out.println("方式一耗时：" + (l2 - l1));
        System.out.println("方式二耗时：" + (l3 - l2));
    }

    public static void testFor2() {
        List<String> list = new ArrayList<String>();
        list.add("11");
        list.add("22");
        list.add("33");
        list.add("44");
        list.add("55");
        for (int k = 0; k < list.size(); k++) {
            if (list.size() == 1 || k < list.size() - 1) {
                System.out.println("kkkkkk=" + list.get(k));
            } else {
                System.out.println("k=" + list.get(k));
            }
        }
    }

    /**
     * for循环初始化顺序 1、初始值；2、判断条件；3、执行主体语句；4：循环变量+步长 注意：判断条件不写默认是true；初始值只会初始化一次
     */
    public static void forInitOrder() {
        //此处打印的结果是abcbcbcbc 一直死循环下去   
        for (System.out.println("a");; System.out.println("c")) {
            System.out.println("b");
        }
    }

    /**
     * 多重for循环 跳出
     */
    public static void forBreak() {
        /**
         * 通过定义outFor、innerFor来跳出外循、还是内循
         */
        System.out.println("----start---");
        outFor: for (int i = 0; i < 5; i++) {

            innerFor: for (int j = 0; j < 10; j++) {
                if (j == 5) {
                    break innerFor;
                }
                System.out.println("x:" + i + ";j:" + j);
            }
        }
        System.out.println("----end---");
    }

    /**
     * 打印三角形
     */
    public static void printTrigon() {
        /**
         * 基本思路： step1:循环嵌套 外层循环控制行，内层循环控制列(直角三角形-尖超上)
         */
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < x + 1; y++) {
                System.out.print("*");//无需换行，请使用print
            }
            System.out.println("");
        }
        System.out.println("-----------------------");
        /**
         * 直角三角形-尖超下 88888 8888 888 88 8
         */
        for (int x = 0; x < 5; x++) {
            for (int y = 5 - x; y > 0; y--) {
                System.out.print("8");
            }
            System.out.println("");
        }
        /**
         * 等腰三角形 88888 8888 888 88 8
         */
        //        for(){
        //            
        //        }

    }
    /**
     * 测试foreach  
     */
    public static void testForeachWithNull(){
    	System.out.println("start");
    	//测试一  会报空指针
    	ArrayList<String> list=null;
    	try {
    		for (String string : list) {
    			System.out.println("string:"+string);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
    	
    	//测试二 不会控指针
//    	List<String> list=new ArrayList<String>();
//    	for (String string : list) {
//    		System.out.println("string:"+string);
//		}
    	
    	System.out.println("end");
    }
    
    public static void main(String[] args) {
        //        testFor2();
        //        forInitOrder();
        //        forBreak();
//        printTrigon();
    	testForeachWithNull();
    }
}
