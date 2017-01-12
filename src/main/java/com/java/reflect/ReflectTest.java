package com.java.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.alibaba.fastjson.JSON;

/**
 * 反射的相关测试
 * 
 * @author linco lee
 */
public class ReflectTest {
    /**
     * 将Object转map
     * 
     * @param obj
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> objectToMap(Object obj) {
        try {
            if (obj instanceof Map) {
                return (Map<String, Object>) obj;
            }
            Class<?> cp = obj.getClass();
            Field[] fs = cp.getDeclaredFields();
            Map<String, Object> map = new HashMap<String, Object>();
            for (Field field : fs) {
                String fieldName = field.getName();//字段名
                String method = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);//字段名对应的get方法
                Method m = cp.getDeclaredMethod(method);//获取指定的get方法
                Object mValue = m.invoke(obj);//调用指定的get方法
                map.put(fieldName, mValue);//key=字段名 value=变量值
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 反射对象拷贝
     * 
     * @setp1 获取源对象和目标对象对应的Class类
     * @step2 根据源对象和目标对象的Class类获取对应的字段
     * @step3 将源对象的字段信息存入map中[key=fieldName value=fieldObject]
     * @step4 遍历目标对象的字段数组，并根据遍历的字段名到map中去匹配源对象相同的字段
     * @step5 然后将源对象的字段值赋值给目标对象字段
     * @param src 源对象
     * @param dest 目标对象
     * @throws Exception
     */
    public static void objectCopy(Object src, Object dest) throws Exception {
        Class<?> srcClass = src.getClass();//源对象
        Class<?> destClass = dest.getClass();//目标对象
        Field[] srcFields = srcClass.getDeclaredFields();//原对象字段
        Field[] destFields = destClass.getDeclaredFields();//目标对象字段

        Map<String, Field> map = new HashMap<String, Field>();
        for (Field temp : srcFields) {
            map.put(temp.getName(), temp);
        }

        for (Field field : destFields) {
            String name = field.getName();
            Field temp = map.get(name);
            if (null == temp) {
                continue;
            }
            field.setAccessible(true);//设置是否可访问私有变量
            temp.setAccessible(true);////设置是否可访问私有变量
            // field.set(Object obj, Object value) 将指定对象变量上此 Field 对象表示的字段设置为指定的新值。
            //field.get(Object obj) 返回指定对象上此 Field 表示的字段的值。
            field.set(dest, temp.get(src));
            field.setAccessible(false);
            temp.setAccessible(false);
        }
    }

    public static <T> T objectCopy(Object obj, Class<T> cl) throws Exception {
        T dest = cl.newInstance();
        objectCopy(obj, dest);
        return dest;

    }

    /**
     * 改变List中的对象
     * 
     * @param list
     * @param c
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static List changeListObj(List list, Class c) throws Exception {
        List result = new ArrayList();
        for (Object o : list) {
            result.add(objectCopy(o, c));
        }
        return result;
    }

    /**
     * @param MethodName
     * @param o 调用此方法的对象
     * @param paras 调用的这个方法的参数参数列表
     */
    public static void getMethod(String MethodName, Object o, Object[] paras) {
        Class c[] = null;
        if (paras != null) {//存在
            int len = paras.length;
            c = new Class[len];
            for (int i = 0; i < len; ++i) {//这里不是java内置类基本数据是不支持的，请一步一步完成，可以参考我的上篇文章<Java通过反射创建对象>
                c[i] = paras[i].getClass();
            }
        }
        try {
            Method method = o.getClass().getDeclaredMethod(MethodName, c);
            method.invoke(o, paras);//调用o对象的方法

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

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

    public static void main(String[] args) throws Exception {
        Person p1 = new Person("张三", 12, '女');
        objectConvertToString(p1);
        PersonBean pb = new PersonBean();
        System.out.println("***********copybefore*************");
        System.out.println(p1);
        System.out.println(pb);
        System.out.println("***********copyafter*************");
        objectCopy(p1, pb);
        System.out.println(p1);
        System.out.println(pb);

        System.out.println("******************changeListObj************************");
        Person p2 = new Person("李四", 23, '男');
        Person p3 = new Person("王五", 22, '男');
        List<Person> pList = new ArrayList<Person>();
        pList.add(p1);
        pList.add(p2);
        pList.add(p3);
        List<PersonBean> pbList = ReflectTest.changeListObj(pList, PersonBean.class);
        for (PersonBean personBean : pbList) {
            System.out.println("pbList:" + personBean);
        }
    }
}
