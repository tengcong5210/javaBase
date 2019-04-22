package com.java.exception;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tengcongcong
 * @create 2017-06-28 9:09
 * @Version 1.0
 **/
public class ExceptionDemo {
    private static final Logger LOGGER= LoggerFactory.getLogger(ExceptionDemo.class);
    @Test
    public void testTryCatch(){
        LOGGER.info("testTryCatch====开始");
       try {
            int a=1/0;
       }catch (Exception e){
           LOGGER.error("testTryCatch====异常",e);
           return;
       }
       LOGGER.info("testTryCatch====结束");//如果异常后，该处代码不会执行
       return;
    }

    @Test
    public void testTryCatch2(){
        LOGGER.info("testTryCatch====开始");
        try {
            int a=1/0;
        }catch (Exception e){
            LOGGER.error("testTryCatch====异常",e);
            return;
        }finally {
            LOGGER.info("testTryCatch====finally");//此处代码会执行
        }
        LOGGER.info("testTryCatch====结束");//如果异常后，该处代码不会执行
        return;
    }
    @Test
    public void testNewException(){
        LOGGER.info("测试创建异常对象");
        try {
            Exception exception=new Exception();
        }catch (Exception e){
            LOGGER.error("测试创建异常对象",e);
            e.printStackTrace();
        }
    }
}
