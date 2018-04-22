package com.java.thread;

import com.java.thread.concurrencyOfArt.chap4.Profiler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ibm on 2017/8/26.
 */
public class MethodInvokeThreadInfoDao {
    private static final Logger LOGGER= LoggerFactory.getLogger(MethodInvokeThreadInfoDao.class);

    public void add(Thread thread) throws InterruptedException {
        Profiler.begin();
        Thread currentThread=Thread.currentThread();
        Thread.sleep(10);
        LOGGER.info("dao.add method's thread name is:{},Thread isEquals:{},cost time:{}毫秒",currentThread.getName(),(currentThread==thread),Profiler.end());
    }
}
