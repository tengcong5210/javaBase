package com.java.String;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang.text.StrSubstitutor;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

public class StringFromt {
    @Test
    public void testStringFromt() throws Exception {
        String stringFormat = "lexical error at position %s, encountered %s, expected %s ";
        String result = String.format(stringFormat, 123, 100, 456);

        String stringFromt2 = "我是%s，我在石投等你。";
        String result2 = String.format(stringFromt2, "张三");

        String stringFromt3 = "【邀好友 共同赚】多重好礼双方赢!";
        String result3 = String.format(stringFromt3, "张三");
        System.out.println("==========" + result);
        System.out.println("==========2" + result2);
        System.out.println("==========3" + result3);
    }
    
    @Test
	public void testName() throws Exception {
		JSONObject json=new JSONObject();
		json.put("utmContent", "");
		json.put("Ip", "");
		json.put("refererPage", "http://m.shitou.com/wechat/regedit/step2?resourceCode=15802143295&from=singlemessage&isappinstalled=1");
		json.put("userAgent", "Mozilla/5.0 (iPhone; CPU iPhone OS 9_3_2 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Mobile/13F69 MicroMessenger/6.3.22 NetType/4G Language/zh_CN");
		json.put("Mobilephone", "13572800000");
		json.put("Versions", "1");
		json.put("Password", "123123");
		json.put("landingPage", "http://m.shitou.com/css/active/sem001.css");
		String str="http://m.shitou.com/wechat/regedit/step2?resourceCode=15802143295&from=singlemessage&isappinstalled=1";
		String userAgent="Mozilla/5.0 (iPhone; CPU iPhone OS 9_3_2 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Mobile/13F69 MicroMessenger/6.3.22 NetType/4G Language/zh_CN";
		String landingPage="http://m.shitou.com/css/active/sem001.css";
		System.out.println(isValid(landingPage));
		System.out.println(("/Api20/telRegister".contains("Api20/telRegister")));
		if(!isValid(str)){
			System.out.println("v=0");
		}else{
			System.out.println("v= other");
		}
		
	}
    private boolean isValid(String str){
		String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|"
				+ "(\\b(select|update|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|from|into|drop|execute|t_user)\\b)";
		Pattern sqlPattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
		if (sqlPattern.matcher(str).find()) {
			return false;
		}
		return true;
	}
    
    @Test
	public void testAppVersion() throws Exception {
		String appVersions="3.2.5";
		String appVersions1="3.2.6";
		String appVersions2="3.3.0";
		String appVersions3="3.2.5";//  "4.0.0"
		String appVersions4="4.0";//  "4.0.0"
		
		String oldVersion="3260";
		String newVersion="3270";
		compareToStr(oldVersion,newVersion);
		
		
	}

	private void compareToStr(String oldVersion, String newVersion) {
		System.out.println(oldVersion.compareTo(newVersion));
		
	}
	
	
	@Test
	public void testFormatAppVersion() throws Exception {
		String appVersions="325";
		System.out.println("格式化后："+appVersions.replaceAll("\\.", ""));
	}
	@Test
	public void isRepeatUrl(){

		Map valuesMap = new HashMap();
		valuesMap.put("aaa", "张三");
		valuesMap.put("bbb", "修改前端页面");
		valuesMap.put("ccc", "00009");
		valuesMap.put("ddd", "www.baidu.com");
    	String str="亲，${aaa}向你提了一个需求${bbb}，需求编号是：${ccc}，请及时评估，详情请见${ddd}";
		StrSubstitutor sub = new StrSubstitutor(valuesMap);
		sub.setEnableSubstitutionInVariables(true);
		String resolvedString = sub.replace(str);
		System.out.println("字符串格式化:"+resolvedString);
	}
}
