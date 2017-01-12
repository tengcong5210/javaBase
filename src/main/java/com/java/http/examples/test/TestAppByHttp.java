package com.java.http.examples.test;

import static org.junit.Assert.*;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.junit.Test;

import com.java.http.examples.HttpHeader;
import com.java.http.examples.HttpMethods;
import com.java.http.examples.HttpUtil;
/**
 * 测试app接口通过http请求
 * @author zhangy
 *
 */
public class TestAppByHttp {
	/**
	 *
	 * @throws Exception
	 */
	@Test
	public void testAssetsSafety() throws Exception {
//		String url="http://localhost:8080/appServer/webapi/assetsSafety/121584";
		String url="http://localhost:8080/appServer/webapi/assetsSafety/651";
//		Map<String, String> parasMap=new HashMap<String, String>();
//		parasMap.put("folderPath", URLEncoder.encode("/帮助中心/文本/费用说明", "utf-8"));
		//请求头
//		Map<String, Header> headerMaps = new HashMap<String, Header>();
//	    headerMaps.put("timestamp", new BasicHeader("timestamp", System.currentTimeMillis() + ""));
//	    headerMaps.put("clientCode", new BasicHeader("clientCode","web"));
	    //发送请求
	    String result=HttpUtil.send(url, HttpMethods.GET, null, null, "utf-8");
	    
		System.out.println("测试结果="+result);
	}
}
