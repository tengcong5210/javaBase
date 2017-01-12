package com.java.arithmetic;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 分页算法
 * @author tcc
 *
 */
public class Page {
	/**
	 * 需求描述：将100条数据批量插入到数据库。
	 * 分析：为了减小数据库压力，我们可以选择分批插入。即每次插入5条，分20次插入
	 * @throws Exception
	 */
	@Test
	public void testPage() throws Exception {
		int totalCount=100;//定义总记录数
		int factor=5;//每次处理因子
		int size=totalCount/factor;//分多少次执行
		if(totalCount%factor!=0){
			size++;
		}
		
		for(int i=1;i<=size;i++){
			System.out.println("********size="+i);
			int start=(i-1)*factor;
			int end=start+factor;
			if(end>totalCount){
				end=totalCount;
			}
			for(int j=start;j<end;j++){
				System.out.println("==========J:"+j);
			}
		}
		
	}
}
