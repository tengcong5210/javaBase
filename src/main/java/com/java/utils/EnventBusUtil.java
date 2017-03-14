package com.java.utils;

import com.google.common.eventbus.AsyncEventBus;
import com.java.utils.event.Event;
import com.java.utils.event.EventListener;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * 基于guava eventbus的调用工具类
 */
public class EnventBusUtil {
    /**
     * 异步调用bean的methodName方法
     * 
     * @param bean
     * @param methodName
     * @param args
     */
    public static void invoke(Object bean, String methodName, Object[] args) {
        EnventBusUtil.invoke(bean, methodName, args, null);
    }

    /**
     * 异步调用bean的methodName方法
     * 
     * @param bean
     * @param methodName
     * @param args
     * @param clazzs
     */
    @SuppressWarnings("rawtypes")
    public static void invoke(Object bean, String methodName, Object[] args, Class[] clazzs) {
        // new一个事件
        Event event = new Event(bean, methodName, args, clazzs);

        // 将事件提交到bus上
        eventBus.post(event);
    }

    /**
     * 多线程,使用固定线程池大小，非指定线程池大小可能大致OOM
     */
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 0l, TimeUnit.MILLISECONDS,
                                                       new LinkedBlockingQueue<Runnable>(10000));
    /**
     * event bus
     */
    private static AsyncEventBus      eventBus = new AsyncEventBus("enventBusUtil", executor);
    //private static EventBus           eventBus = new EventBus("enventBusUtil");

    /**
     * 事件监听器
     */
    private static EventListener listener = new EventListener();

    static {
        // 注册监听器到bus
        eventBus.register(listener);

        //启动线程
        executor.prestartAllCoreThreads();

    }

}
