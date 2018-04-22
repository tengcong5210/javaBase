package com.java;

import com.java.thread.concurrencyOfArt.chap1.ConcurrencyTest;
import com.java.tool.ProfilerTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 类MainTest.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2016年2月3日 下午3:36:38
 * @version 1.0.0
 */
public class MainTest {
   private static final Logger LOGGER= LoggerFactory.getLogger(MainTest.class);

   public static void main(String[] args) throws InterruptedException {
       LOGGER.info("MainTest:"+Thread.currentThread().getName()+" is start");
        ProfilerTool.begin();

       /*ConcurrencyTest.concurrency();*/

       ConcurrencyTest.serial();


        LOGGER.info("MainTest:"+Thread.currentThread().getName()+" is end,耗时:{}",ProfilerTool.end());

    }
}
