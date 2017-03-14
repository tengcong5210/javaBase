package com.java.utils.event;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * 事件监听类， 通过反射调用传入event中的方法
 */
public class EventListener {
    private final static Logger logger = LoggerFactory.getLogger(EventListener.class);

    @Subscribe
    @AllowConcurrentEvents
    public void listen(Event event) throws Exception {
        if (null == event) {
            logger.warn("EventListener.listen() event is null, do nothing");
            return;
        }

        //目标方法参数列表
        Object[] args = event.getArgs();

        //目标方法参数类型列表
        @SuppressWarnings("rawtypes")
        Class[] parameterTypes = event.getClazzs();

        if (null == parameterTypes) {
            if (null != args && args.length > 0) {
                parameterTypes = new Class[args.length];
                for (int i = 0; i < args.length; i++) {
                    parameterTypes[i] = args[i].getClass();
                }
            }
        }

        //取bean的方法对象
        Method method = event.getBean().getClass().getDeclaredMethod(event.getMethodName(), parameterTypes);
        method.setAccessible(true);

        //调用目标方法
        method.invoke(event.getBean(), args);

    }
}
