package com.java.dataType;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.java.dataType.bean.IntegerBeanTest;


/**
 * 类IntegerTest.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2016年3月9日 上午11:31:04
 * @version 1.0.0
 */
public class IntegerTest {
    @Test
    public void test(String[] args) {
        Integer i = 10; //装箱 底层jvm会自动调用Integer.valueOf();【-128-127】
        int ii = i; //拆箱 底层jvm会自动掉intValue 

        Integer in = 100;
        Integer in2 = 100;
        Integer in3 = 200;
        Integer in4 = 200;
        System.out.println(in == in2);
        System.out.println(in3 == in4);
        Long l = 10L;
        Long l2 = 10L;
        Long l3 = 200L;
        Long l4 = 200L;
        System.out.println(l == l2);
        System.out.println(l3 == l4);

        Double d1 = 100.0;
        Double d2 = 100.0;
        Double d3 = 200.0;
        Double d4 = 200.0;
        System.out.println(d1 == d2);
        System.out.println(d3 == d4);

        Boolean b1 = false;
        Boolean b2 = false;
        Boolean b3 = true;
        Boolean b4 = true;
        System.out.println(b1 == b2);
        System.out.println(b3 == b4);
    }

    @Test
    public void testInteger() throws Exception {
        Integer a = null;
        Integer b = null;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("aaa", (a == null ? 0 : a) + (b == null ? 0 : b));
        System.out.println("result=" + map);
    }
    /**
     * Integer 包装类 给 int 赋值出现的问题
     * @throws Exception
     */
    @Test
	public void testWrapperToBasic() throws Exception {
    	
    	try {
    		
    		IntegerBeanTest beanTest=new IntegerBeanTest();
//    		test 1: 将Integer null值赋值给int类型
//    		beanTest.setAge(null);   编译不通过  null 可以赋值 任何引用类型 ，但不能赋值给基本数据类型
    		//test 2: 将Integer null值赋值给int类型
    		beanTest.setAge(beanTest.getCount());
    		System.out.println(beanTest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

