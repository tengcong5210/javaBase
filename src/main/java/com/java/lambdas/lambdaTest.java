package com.java.lambdas;

import org.junit.Test;

/**
 * @创建人 tengcc
 * @创建时间 2018/9/9
 * @描述
 * 参考: https://www.cnblogs.com/franson-2016/p/5593080.html
 */
public class lambdaTest {
    @Test
    public void testLambda(String[] args) {
        // 1.1使用匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world !");
            }
        }).start();
        // 1.2使用 lambda expression
        new Thread(()->printStr() ).start();


        // 2.1使用匿名内部类
        Runnable race1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world !");
            }
        };

        // 2.2使用 lambda expression
        Runnable race2 = () -> System.out.println("Hello world !");


    }

    public static void printStr(){
        System.out.println("lambda expression  !");
    }

    @Test
    public void testEx(){
        // 1. 不需要参数,返回值为 5


       /* // 2. 接收一个参数(数字类型),返回其2倍的值
        x -> 2 * x;

        // 3. 接受2个参数(数字),并返回他们的差值
        (x, y) -> x – y;

        // 4. 接收2个int型整数,返回他们的和
        (int x, int y) -> x + y;

        // 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)
        (String s) -> System.out.print(s);*/

    }


}
