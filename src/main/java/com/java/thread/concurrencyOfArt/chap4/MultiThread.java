package com.java.thread.concurrencyOfArt.chap4;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 通过JMX(Java Management Extensions)查看java程序包含哪些线程。
 * Created by ibm on 2017/4/4.
 */
public class MultiThread {
    @SuppressWarnings("Since15")
    public static void main(String[] args){
        //获取java线程管理MxBean
        ThreadMXBean threadMXBean= ManagementFactory.getThreadMXBean();
        //不需要获取同步的montor和synchronized信息。仅获取线程堆栈信息.
        ThreadInfo[] threadInfos=threadMXBean.dumpAllThreads(false,false);

        for (ThreadInfo threadInfo:threadInfos){
            System.out.println("["+threadInfo.getThreadId()+"]"+threadInfo.getThreadName());
        }

    }
}
