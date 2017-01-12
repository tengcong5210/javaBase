package com.java.annations.fruit;

import com.java.annations.fruit.FruitColor.Color;

/**
 * 在苹果中使用注解
 * @author tcc
 *
 */
public class Apple {
	//名称
	@FruitName("Apple")
	private String applyName;
	//颜色
	@FruitColor(fruitColor=Color.BULE)
	private String applyColor;
	//供应商
	@FruitProvider(id=1,name="上海小苹果集团",address="上海市静安区石门一路")
	private String applyProvider;
	
	public String getApplyName() {
		return applyName;
	}
	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}
	public String getApplyColor() {
		return applyColor;
	}
	public void setApplyColor(String applyColor) {
		this.applyColor = applyColor;
	}
	public String getApplyProvider() {
		return applyProvider;
	}
	public void setApplyProvider(String applyProvider) {
		this.applyProvider = applyProvider;
	}
	
}
