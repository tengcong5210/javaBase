package com.java.forT;

import java.util.Iterator;

/**
 * List 为什么可以用Foreach进行遍历
 * @author tcc
 *
 */
public class ForeachIterator {
	
	public static void main(String[] args) {
		TestForeach tf=new TestForeach();
		tf.setStr("张三");
		for (char t : tf) {
			System.out.println("结果："+t);
		}
	}
}


class TestForeach implements Iterable<Character>{
	private String str;
	
	@Override
	public Iterator<Character> iterator() {
		return new Iterator<Character>() {
			private int index=0;

			@Override
			public boolean hasNext() {
				System.out.println("index="+index+";str.length()="+str.length());
				return index<str.length();
			}

			@Override
			public Character next() {
				return str.toCharArray()[index++];
			}

			@Override
			public void remove() {
				
			}
			
		};
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
}