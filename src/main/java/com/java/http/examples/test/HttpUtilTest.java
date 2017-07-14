package com.java.http.examples.test;

import com.java.http.examples.HttpHeader;
import com.java.http.examples.HttpMethods;
import com.java.http.examples.HttpUtil;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.junit.Test;

import java.net.InetAddress;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class HttpUtilTest {
	/**
	 * 测试登录app
	 * @throws Exception
	 */
	@Test
	public void testLogin() throws Exception {
		String url="http://18.16.200.47:9003/dev-appapi/v4/user/login.do";
		//请求参数
		Map<String, String> parasMap=new HashMap<String, String>();
		parasMap.put("loginName", "18616181111");
		parasMap.put("password", "96e79218965eb72c92a549dd5a330112");
		parasMap.put("verifyCode", "WNYZ");
		parasMap.put("pushToken", "1111");
		//请求头
		Map<String, Header> headerMaps = new HashMap<String, Header>();
	    headerMaps.put("timestamp", new BasicHeader("timestamp", System.currentTimeMillis() + ""));
	    headerMaps.put("clientCode", new BasicHeader("clientCode","app"));
	    //发送请求
	    String result=HttpUtil.send(url, HttpMethods.POST, parasMap, HttpHeader.getHeaders(headerMaps), "utf-8");
	    //{"code":"000000","msg":"成功","data":{"accessToken":"427ddd10f34e2bba625912b8efe5e172","expiresIn":"259200","refreshToken":"refreshToken:427ddd10f34e2bba625912b8efe5e172"}}
		System.out.println("测试结果="+result);
	}
	/**
	 * 测试消息内容
	 * @throws Exception
	 */
	@Test
	public void testMessageContent() throws Exception {
		String url="http://18.16.200.47:9003/dev-appapi/v4/messageContent.do";
		//请求参数
		Map<String, String> parasMap=new HashMap<String, String>();
		parasMap.put("appNoticeId", "317623");
		//请求头
		Map<String, Header> headerMaps = new HashMap<String, Header>();
	    headerMaps.put("timestamp", new BasicHeader("timestamp", System.currentTimeMillis() + ""));
	    headerMaps.put("clientCode", new BasicHeader("clientCode","app"));
	    headerMaps.put("accessToken", new BasicHeader("accessToken","427ddd10f34e2bba625912b8efe5e172"));
	    //发送请求
	    String result=HttpUtil.send(url, HttpMethods.POST, parasMap, HttpHeader.getHeaders(headerMaps), "utf-8");
	    
		System.out.println("测试结果="+result);
	}
	
	/**
	 * app首页推荐好友地址
	 * @throws Exception
	 */
	@Test
	public void testAppRecommendUrl() throws Exception {
		String url="http://18.16.200.47:9003/dev-appapi/v4/appRecommendUrl.do";
	    Map<String, Header> headerMaps = new HashMap<String, Header>();
	    headerMaps.put("timestamp", new BasicHeader("timestamp", System.currentTimeMillis() + ""));
	    headerMaps.put("clientCode", new BasicHeader("clientCode","app"));
//	    headerMaps.put("Content-Type", new BasicHeader("Content-Type","application/x-www-form-urlencoded"));
		String result=HttpUtil.send(url, HttpMethods.GET, null, HttpHeader.getHeaders(headerMaps), "utf-8");
		System.out.println("测试结果="+result);
	}
	/**
	 * 常见问题2
	 * @throws Exception
	 */
	@Test
	public void testCommonQuestion2() throws Exception {
//		String url="http://localhost:8480/local-webapi/v4/setting/helpList2.do";
		String url="http://18.16.200.48:9004/dev-webapi/v4/setting/helpList2.do";
		//请求参数
		Map<String, String> parasMap=new HashMap<String, String>();
		parasMap.put("folderPath", URLEncoder.encode("/帮助中心/文本/操作指南/注册认证操作", "utf-8"));
		parasMap.put("page", "1");
		parasMap.put("rows", "5");
		//请求头
		Map<String, Header> headerMaps = new HashMap<String, Header>();
	    headerMaps.put("timestamp", new BasicHeader("timestamp", System.currentTimeMillis() + ""));
	    headerMaps.put("clientCode", new BasicHeader("clientCode","web"));
	    //发送请求
	    String result=HttpUtil.send(url, HttpMethods.POST, parasMap, HttpHeader.getHeaders(headerMaps), "utf-8");
	    
		System.out.println("测试结果="+result);
	}
	/**
	 * 常见问题1
	 * @throws Exception
	 */
	@Test
	public void testCommonQuestion1() throws Exception {
		String url="http://localhost:8480/local-webapi/v4/setting/helpList.do";
//		String url="http://18.16.200.48:9004/dev-webapi/v4/setting/helpList2.do";
		//请求参数
		Map<String, String> parasMap=new HashMap<String, String>();
		parasMap.put("folderPath", URLEncoder.encode("/帮助中心/文本/费用说明", "utf-8"));
		//请求头
		Map<String, Header> headerMaps = new HashMap<String, Header>();
	    headerMaps.put("timestamp", new BasicHeader("timestamp", System.currentTimeMillis() + ""));
	    headerMaps.put("clientCode", new BasicHeader("clientCode","web"));
	    //发送请求
	    String result=HttpUtil.send(url, HttpMethods.POST, parasMap, HttpHeader.getHeaders(headerMaps), "utf-8");
	    
		System.out.println("测试结果="+result);
	}
	/**
	 * web许小年专题
	 * @throws Exception
	 */
	@Test
	public void testMrxu() throws Exception {
		String url="http://www.shitou.com/active/mrxu";
		String result=HttpUtil.send(url, HttpMethods.GET, null, null, "utf-8");
	    System.out.println("测试结果="+result);
	}

	/**
	 * 模拟网贷天眼注册
	 * @throws Exception
	 */
    @Test
	public void testNetLoanEye()throws Exception{
		String url="http://localhost:8080/netLoanEye/memberRegister.do";
		Map<String, String> parasMap=new HashMap<String, String>();
		parasMap.put("data", "mobile=18909121636&username=aaaa&send_time=2017-05-23&sid=11111122");
		String result=HttpUtil.send(url, HttpMethods.POST, parasMap, null, "utf-8");
		System.out.println("测试结果="+result);
	}

	/**
	 * 模拟投之家创建新用户
	 *
	 * @throws Exception
	 */
	@Test
	public void testTzjCreateUser()throws Exception{
		InetAddress address = InetAddress.getLocalHost();//获取的是本地的IP地址 //PC-20140317PXKX/192.168.0.121
		String hostAddress = address.getHostAddress(); //192.168.0.121
		System.out.println("主机地址:"+hostAddress);
	}
	
}
