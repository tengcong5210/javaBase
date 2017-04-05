package com.java.thread.concurrencyOfArt.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by ibm on 2017/4/5.
 */
public class SleepUtils {
    /**
     * 日志对象
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SleepUtils.class);

    public static final void second(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            LOGGER.error("休眠异常",e);
        }

    }
}
