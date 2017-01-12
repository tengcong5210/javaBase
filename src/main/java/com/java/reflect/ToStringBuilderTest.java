package com.java.reflect;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.alibaba.fastjson.JSON;

public class ToStringBuilderTest {
    /**
     * object转String
     */
    public static void objectConvertToString(Object obj) {
        List<Object> objList = new ArrayList<Object>();
        objList.add(obj);
        //com.java.reflect.Person@12276af2[name=张三,age=12,sex=女]
        System.out.println("DEFAULT_STYLE:" + ToStringBuilder.reflectionToString(obj, ToStringStyle.DEFAULT_STYLE));//默认格式
        //        com.java.reflect.Person@12276af2[
        //                                         name=张三
        //                                         age=12
        //                                         sex=女
        //                                       ]
        System.out.println("MULTI_LINE_STYLE:"
                + ToStringBuilder.reflectionToString(obj, ToStringStyle.MULTI_LINE_STYLE));//
        //com.java.reflect.Person@12276af2[张三,12,女]
        System.out.println("NO_FIELD_NAMES_STYLE:"
                + ToStringBuilder.reflectionToString(obj, ToStringStyle.NO_FIELD_NAMES_STYLE));
        //Person[name=张三,age=12,sex=女]
        System.out.println("SHORT_PREFIX_STYLE:"
                + ToStringBuilder.reflectionToString(obj, ToStringStyle.SHORT_PREFIX_STYLE));
        //张三,12,女
        System.out.println("SIMPLE_STYLE:" + ToStringBuilder.reflectionToString(obj, ToStringStyle.SIMPLE_STYLE));

        System.out.println("SHORT_PREFIX_STYLE-objList:"
                + ToStringBuilder.reflectionToString(objList, ToStringStyle.SHORT_PREFIX_STYLE));
        System.out.println("JSON.toJSONString(objList)：" + JSON.toJSONString(objList));
    }

    public static void main(String[] args) {
        Person p1 = new Person("张三", 12, '女');
        objectConvertToString(p1);
    }
}
