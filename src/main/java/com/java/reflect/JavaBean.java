package com.java.reflect;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * javaBean 内省操作
 * 
 * @author linco lee
 */
public class JavaBean {

    public static void main(String[] args) throws Exception {
//        propertyTest();
    	Class clzss=Person.class;
    	Constructor[] cons=clzss.getConstructors();
    	for (Constructor constructor : cons) {
    		Class[] clzsses=constructor.getParameterTypes();
    		StringBuffer sb=new StringBuffer();
    		for(int i=0;i<clzsses.length;i++){
    			sb.append(clzsses[i].getName());
    			if(i!=clzsses.length-1){
    				sb.append(",");
    			}
    		}
    		System.out.println("cons="+constructor.getName()+";参数类型:"+sb.toString());
		}
    }
  
	@SuppressWarnings("unused")
	private static void propertyTest() throws NoSuchFieldException,
			IntrospectionException, IllegalAccessException,
			InvocationTargetException {
		Person pe = new Person("张三", 23, '1');
        String propertyName = pe.getClass().getDeclaredField("name").getName();//获取pe对象的name属性名

        System.out.println("propertyName:" + propertyName.substring(0, 1).toUpperCase()
                + propertyName.substring(1, propertyName.length()));
        PropertyDescriptor pd = new PropertyDescriptor(propertyName, pe.getClass()); //javabean 方法操作 
        Method method = pd.getReadMethod();//获得应该用于读取属性值的方法。此示例是getName
        System.out.println("methodName:" + method.getName());
        Object retObj = method.invoke(pe);
        System.out.println("retObj:" + retObj);
	}
}
