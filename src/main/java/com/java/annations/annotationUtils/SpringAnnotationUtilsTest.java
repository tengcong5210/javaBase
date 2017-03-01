package com.java.annations.annotationUtils;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Map;

/**
 * Spring注解工具类
 * 博文：http://jakoes.iteye.com/blog/712753
 * Created by ibm on 2017/3/1.
 */
public class SpringAnnotationUtilsTest {
    /**
     * 通过注解获取类属性的描述
     */
    @Test
    public void testColumnDesc(){
        Field[] fields=TestBean.class.getDeclaredFields();
        for (Field field:fields){
            Annotation[] ans =field.getAnnotations();
            for (Annotation annotation :ans){
                if(annotation instanceof ColumnAnnotation){
                    //获取给定注解的属性值，存有map中
                    Map<String, Object> map=AnnotationUtils.getAnnotationAttributes(annotation);
                    System.out.println("map:"+ JSON.toJSONString(map));
                    //获取给定注解的属性值
                    String object=(String)AnnotationUtils.getValue(annotation,"desc");
                    System.out.println("object:"+object);
                }
            }
        }
    }
}

class TestBean{
    @ColumnAnnotation(desc = "bean名称")
    private String beanName;
    @ColumnAnnotation(desc = "bean方法")
    private String beanMethod;
}


