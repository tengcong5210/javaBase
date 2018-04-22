package com.java.thread.concurrencyOfArt.chap1;

import com.java.tool.ProfilerTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ibm on 2017/7/30.
 */
public class ConcurrencyTest2 {
    private static final Logger LOGGER= LoggerFactory.getLogger(ConcurrencyTest2.class);

    private static final long count=100000000l;

    //串行
    public static void serial(){
        ProfilerTool.begin();
        long start=System.currentTimeMillis();
        int a=0;
        for(long i=0;i<count;i++){
            a+=5;
        }
        int b=0;
        for (long i=0;i<count;i++){
            b--;
        }
        long time=System.currentTimeMillis()-start;
        System.out.println("ConcurrencyTest2 serial:"+time+"ms,b="+b+",a="+a);
        LOGGER.info("ConcurrencyTest2.serial()"+Thread.currentThread().getName()+"is end,耗时:{}",ProfilerTool.end());
    }
}
