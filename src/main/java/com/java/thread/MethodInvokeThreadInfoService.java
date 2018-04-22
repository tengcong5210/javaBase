package com.java.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ibm on 2017/8/26.
 */
public class MethodInvokeThreadInfoService {
    private static final Logger LOGGER= LoggerFactory.getLogger(MethodInvokeThreadInfoService.class);
    private MethodInvokeThreadInfoDao dao=new MethodInvokeThreadInfoDao();

    public void add(Thread thread) throws InterruptedException {
        Thread currentThread=Thread.currentThread();
        LOGGER.info("service.add method's thread name is:{},Thread isEquals:{}",currentThread.getName(),(currentThread==thread));
        dao.add(currentThread);
        Thread.sleep(10);
    }
}
