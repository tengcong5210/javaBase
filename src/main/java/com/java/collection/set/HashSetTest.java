package com.java.collection.set;


import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

/**
 * hashset集合
 * 
 * @author linco lee
 */
public class HashSetTest {
   
	/**
	 * 重复元素的数组去重
	 * @throws Exception
	 */
	@Test
	public void testArrayToHashSet() throws Exception {
			String[] strs="A,B,C,A,D".split(",");
			Set<String> hashSet=new HashSet<String>(Arrays.asList(strs));
			for (String string : hashSet) {
				System.out.println("无序:"+string);
			}
			
			Set<String> linkSet=new LinkedHashSet<String>(Arrays.asList(strs));
			for (String string : linkSet) {
				System.out.println("有序:"+string);
			}
	}
   
}
