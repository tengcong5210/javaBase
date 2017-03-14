package com.java.utils.event;

import java.io.Serializable;

/**
 * 被监听事件
 */
public class Event implements Serializable {
    private static final long serialVersionUID = 4161755693819623893L;

    /**
     * bean
     */
    private Object            bean;

    /**
     * 方法名
     */
    private String            methodName;

    /**
     * 参数
     */
    private Object[]          args;

    @SuppressWarnings("rawtypes")
    private Class[]           clazzs;

    public Event(Object bean, String methodName, Object[] args) {
        this.bean = bean;
        this.methodName = methodName;
        this.args = args;
    }

    public Event(Object bean, String methodName, Object[] args, @SuppressWarnings("rawtypes") Class[] clazzs) {
        this.bean = bean;
        this.methodName = methodName;
        this.args = args;
        this.clazzs = clazzs;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    @SuppressWarnings("rawtypes")
    public Class[] getClazzs() {
        return clazzs;
    }

    @SuppressWarnings("rawtypes")
    public void setClazzs(Class[] clazzs) {
        this.clazzs = clazzs;
    }

}
