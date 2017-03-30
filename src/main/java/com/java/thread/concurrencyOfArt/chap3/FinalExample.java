package com.java.thread.concurrencyOfArt.chap3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ibm on 2017/3/30.
 */
public class FinalExample {
    private static  final Logger LOGGER= LoggerFactory.getLogger(FinalExample.class);
    int i;//普通变量
    final int j;//final域变量
    static FinalExample obj;
    //构造函数
    public FinalExample(){
        i=1;//写普通域
        j=2;//写final域
    }
    public static void writer(){//写线程A执行
        LOGGER.info("====>writer");
        obj=new FinalExample();
    }

    public static void reader(){//读线程B执行
        LOGGER.info("====>reader");
        FinalExample object=obj;//读对象引用
        int a=object.i;//读普通域
        int b=object.j;//读final域
        LOGGER.info("====>a:{},b:{}",a,b);
    }
    //当开启2个线程分别去执行writer、和reader时 第27行有时会报NPE,请思考为什么
    //Exception in thread "Thread-1" java.lang.NullPointerException
    //at com.java.thread.concurrencyOfArt.chap3.FinalExample.reader(FinalExample.java:27)
    public static void main(String[] args){

        LOGGER.info("开始");
        Thread a=new Thread(new Runnable() {
            public void run() {
                FinalExample.writer();
            }
        });
        Thread b=new Thread(new Runnable() {
            public void run() {
                FinalExample.reader();
            }
        });
        a.start();
        b.start();
        LOGGER.info("结束");
    }

}
