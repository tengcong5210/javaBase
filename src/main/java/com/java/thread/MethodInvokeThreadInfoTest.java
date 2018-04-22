package com.java.thread;

import com.java.thread.concurrencyOfArt.chap4.Profiler;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试一个方法中调用其他方法的线程是否为同一个线程对象
 * Created by ibm on 2017/8/26.
 */
public class MethodInvokeThreadInfoTest {
    private static final Logger LOGGER= LoggerFactory.getLogger(MethodInvokeThreadInfoTest.class);

    private MethodInvokeThreadInfoService service=new MethodInvokeThreadInfoService();

    @Test
    public void testStart() throws InterruptedException {
        Profiler.begin();
        Thread currentThread=Thread.currentThread();
        LOGGER.info("testStart method's thread name is:{}",currentThread.getName());
        service.add(currentThread);

        LOGGER.info("testStart method's cost time:{}",Profiler.end());
    }
}
