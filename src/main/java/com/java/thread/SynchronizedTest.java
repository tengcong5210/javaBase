package com.java.thread;

public class SynchronizedTest{
	
	private static int i=0;
	
	public static void main(String[] args){
		
		synchronized (SynchronizedTest.class){
			i++;
		}
		
	}
	
}