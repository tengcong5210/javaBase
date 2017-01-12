package com.java.String;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

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
		String url="http://dbei-file.oss-cn-hangzhou.aliyuncs.com/%E6%88%BF%E5%B1%8B%E4%B9%B0%E5%8D%96%E8%B4%B7/%E5%80%9F%E6%AC%BE%E4%BA%BA%E4%BF%A1%E6%81%AF/%E8%BA%AB%E4%BB%BD%E8%AF%81/f5ea6c55-9d2d-4d0f-9f39-96018b26aa76.png?Expires=1480405621&OSSAccessKeyId=STS.JWoAjL2Jwbf9G8Tb2nKRLjK7g&Signature=k9beHt6EvpImjw4Hb1D2ByLv7Vo%3D&security-token=CAESmwQIARKAAS/yqI1Dc/IoB0%2BSqFfo38J5Bobk6KxGxeNbyF4Uf4GptEnV/njIfOtKvr9LWMoj23vTUcBtmtuQDqoyc/w9bj0kGw9tuRo4aX0J1TrTtX/sa%2BCXRUWV4GLS7U1T8NxNKND4JaPgvvAhAJbbFcCdl2XbJ5AOc/P2P%2BT6/4ZjihBZGh1TVFMuSldvQWpMMkp3YmY5RzhUYjJuS1JMaks3ZyISMzEyNzI4ODc5MDg4MjM3MzYzKglhbGljZS0wMDEwo6ib%2BYorOgZSc2FNRDVC4AEKATEa2gEKBUFsbG93EoIBCgxBY3Rpb25FcXVhbHMSBkFjdGlvbhpqCg1vc3M6R2V0T2JqZWN0Cg1vc3M6UHV0T2JqZWN0ChBvc3M6RGVsZXRlT2JqZWN0Cg1vc3M6TGlzdFBhcnRzChhvc3M6QWJvcnRNdWx0aXBhcnRVcGxvYWQKD29zczpMaXN0T2JqZWN0cxJMCg5SZXNvdXJjZUVxdWFscxIIUmVzb3VyY2UaMAoXYWNzOm9zczoqOio6ZGJlaS1maWxlLyoKFWFjczpvc3M6KjoqOmRiZWktZmlsZUoQMTI2MTM5NzIwODYwNDkwOVIFMjY4NDJaD0Fzc3VtZWRSb2xlVXNlcmAAahIzMTI3Mjg4NzkwODgyMzczNjNyG2FsaXl1bm9zc3Rva2VuZ2VuZXJhdG9ycm9sZXjtwajkvueeAg%3D%3D";
		url=url.substring(url.indexOf("Expires="));
		System.out.println("新的Url:"+url);
		String expires=url.substring(url.indexOf("=")+1, url.indexOf("&"));
		System.out.println(expires);
		//url中的过期时间
		Long exp=Long.valueOf(expires)*1000L;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d = format.format(exp);
		System.out.println("d="+d);
		System.out.println("exp:"+exp);
		//当前时间
		Long newTime=new Date().getTime();
		System.out.println("newDateLime:"+newTime);
		System.out.println("new:"+format.format(newTime));
		
		//当前时间和过期时间差
		Long cha=exp-newTime;
		System.out.println("cha:"+cha);
		if(cha>0){
			System.out.println("相差多少分钟："+(cha/1000L));
		}
		
		
		
	}
}
