package com.java.http.examples.test;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.java.http.examples.ParamMap;

/**
 * @ClassName: ParamMapTest
 * @Description: 参数传递封装类
 * @author 冰水华川QQ757225051
 * @date 2014-7-15 16:28:22
 */
public class ParamMapTest {

//	/**
//	 * @Title: main
//	 * @Description: 工具类的测试,文件的用法
//	 * @param args 固定参数
//	 * @return void 无
//	 * @throws 无
//	 */
//	public static void main(String[] args) {
//		ParamMap map=new ParamMap();
//		map.put("age", 123);
//		System.out.println(map.getStr("age")+9);
//		map.put("name", "111");
//		System.out.println(map.getInt("name")+9);
//		int size=map.size();
//		System.out.println(size);
//		System.out.println(map.isEmpty());
//		map.clear();
//		size=map.size();
//		System.out.println(size);
//		System.out.println(map.isEmpty());
//		map.put("birthday", "1990-10-21");
//		System.out.println(map.getDate("birthday"));
//		map.put("now", new Date());
//		System.out.println(map.getStr("now"));
//		new ParamMapTest().test1();
//		ParamMapTest.test2();
//		ParamMapTest.test3();
//	}
	@Test
	public void test1(){
		ParamMap map=new ParamMap();
		map.put("name", "abc");
		map.put("addr", "def");
		String str1=(String)map.get("name");
		String str2=(String)map.get("addr");
		String str3=map.getStr("name");
		String str4=map.getStr("addr");
		System.out.println("str1="+str1);
		System.out.println("str2="+str2);
		System.out.println("str3="+str3);
		System.out.println("str4="+str4);
	}
	@Test
	public  void test2(){
		ParamMap map=new ParamMap();
		map.put("name", "abc");
		map.put("addr", "def");
		map.put("date", new Date());
		System.out.println(map);
		Map<String,String>map2=new HashMap<String,String>();
		map2.put("aaa", "AAA");
		map2.put("bbb", "BBB");
		map.putAll(map2);
		System.out.println(map);
	}
	@Test
	public  void test3(){
		ParamMap map=new ParamMap();
		map.put("name", "aaa");
		map.put("age", 13);
		map.put("test", "5");
		Set<String>set=map.keySet();
		System.out.println(set);
		Collection<Object> val=map.values();
		System.out.println(val);
	}
}

