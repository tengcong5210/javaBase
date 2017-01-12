package com.java.thread;
/**
 * 测试执行顺序
 * @author zhangy
 *
 */
public class EnventBusUtil {
	
	public static void main(String[] args) {
		System.out.println("main");
		EnventBusUtil en=new EnventBusUtil();
	}
	//静态变量  在类加载 后 准备阶段  统一在类构造器Cinlit
	private static String name=getName();
	
	//代码块优先实例构造函数
	{
	  System.out.println("code block");	
	}
	//静态块  Cinlit
	static{
		System.out.println("static block");
	}
	
	private static String getName(){
		System.out.println("getName");
		return "张三";
	}
	//实例构造器 ilint
	public EnventBusUtil(){
		System.out.println("contructor");
	}
}
