package com.java.log;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * sl4j+log4j 使用
 * 
 * @author linco lee
 */
public class LogTest {
    /**
     * 日志对象
     */
    private static Logger logger = LoggerFactory.getLogger(LogTest.class);

    /**
     * 通过log打印日志异常堆栈信息
     */
    public static void printHeapStackByLog() {
        String amount = "1000.00";
        try {
            Long.parseLong(amount);
        } catch (Exception e) {
            /**
             * 经验证 logger.error("xxxx",exception) 是打印堆栈信息
             */
            logger.error("long parseLong error ,message:" + e.getMessage());
            logger.error("long parseLong error ,message:" + ToStringBuilder.reflectionToString(e));
            logger.error("long parseLong error ", e);
            throw new RuntimeException(e);
        }
        Long.parseLong(amount);
        System.out.println("会执行吗");

    }

    public static void main(String[] args) {
        logger.info("start main");
        try {
            printHeapStackByLog();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //        printHeapStackByLog();
    }

}
