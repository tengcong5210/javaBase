package com.java.http.examples;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.java.log.LogTest;

/**
 * http请求工具
 * 
 * @author tengcongcong
 */
public class HttpUtil {
	/**
     * 日志对象
     */
    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);
	/**
	 * 请求资源或服务，自定义client对象，传入请求参数，设置内容类型，并指定参数和返回数据的编码
	 * 
	 * @param client		client对象
	 * @param url			资源地址
	 * @param httpMethod	请求方法
	 * @param parasMap		请求参数
	 * @param headers		请求头信息
	 * @param encoding		编码
	 * @return				返回处理结果
	 * @throws Exception 
	 */
	public static String send(HttpClient client, String url, HttpMethods httpMethod, Map<String,String>parasMap,
				Header[] headers, String encoding) throws Exception {
		String body = "";
		try {
			//创建请求对象
			HttpRequestBase request = getRequest(url, httpMethod);
			
			//设置header信息
			request.setHeaders(headers);
			
			//判断是否支持设置entity(仅HttpPost、HttpPut、HttpPatch支持)
			if(HttpEntityEnclosingRequestBase.class.isAssignableFrom(request.getClass())){
				List<NameValuePair> nvps = new ArrayList<NameValuePair>();
				
				//检测url中是否存在参数
				url = Utils.checkHasParas(url, nvps);
				
				//装填参数
				Utils.map2List(nvps, parasMap);
				
				//设置参数到请求对象中
				((HttpEntityEnclosingRequestBase)request).setEntity(new UrlEncodedFormEntity(nvps, encoding));
				
				logger.debug("请求地址："+url);
				if(nvps.size()>0){
					logger.debug("请求参数："+nvps.toString());
				}
			}else{
				int idx = url.indexOf("?");
				logger.debug("请求地址："+url.substring(0, (idx>0 ? idx-1:url.length()-1)));
				if(idx>0){
					logger.debug("请求参数："+url.substring(idx+1));
				}
			}
			
			//调用发送请求
			body = execute(client, request, url, encoding);
			
		} catch (UnsupportedEncodingException e) {
			throw new Exception(e);
		}
		return body;
	}
		
	
	/**
	 * 请求资源或服务
	 * 
	 * @param client		client对象
	 * @param request		请求对象
	 * @param url			资源地址
	 * @param parasMap		请求参数
	 * @param encoding		编码
	 * @return				返回处理结果
	 * @throws Exception 
	 */
	private static String execute(HttpClient client, HttpRequestBase request,String url, String encoding) throws Exception {
		String body = "";
		HttpResponse response =null;
		try {
			
			//执行请求操作，并拿到结果（同步阻塞）
			response = client.execute(request);
			
			//获取结果实体
			HttpEntity entity = response.getEntity();
			
			if (entity != null) {
				//按指定编码转换结果实体为String类型
				body = EntityUtils.toString(entity, encoding);
				logger.debug(body);
			}
			EntityUtils.consume(entity);
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			close(response);
		}
		
		return body;
	}
	/** 
	 * 根据请求方法名，获取request对象 
	 *  
	 * @param url                   资源地址 
	 * @param method            请求方式 
	 * @return 
	 */  
	private static HttpRequestBase getRequest(String url, HttpMethods method) {  
	    HttpRequestBase request = null;  
	    switch (method.getCode()) {  
	        case 0:// HttpGet  
	            request = new HttpGet(url);  
	            break;  
	        case 1:// HttpPost  
	            request = new HttpPost(url);  
	            break;  
	        case 2:// HttpHead  
	            request = new HttpHead(url);  
	            break;  
	        case 3:// HttpPut  
	            request = new HttpPut(url);  
	            break;  
	        case 4:// HttpDelete  
	            request = new HttpDelete(url);  
	            break;  
	        case 5:// HttpTrace  
	            request = new HttpTrace(url);  
	            break;  
	        case 6:// HttpPatch  
	            request = new HttpPatch(url);  
	            break;  
	        case 7:// HttpOptions  
	            request = new HttpOptions(url);  
	            break;  
	        default:  
	            request = new HttpPost(url);  
	            break;  
	    }  
	    return request;  
	} 
	/** 
	 * 尝试关闭response 
	 *  
	 * @param resp              HttpResponse对象 
	 */  
	private static void close(HttpResponse resp) {  
	    try {  
	        if(resp == null) return;  
	        //如果CloseableHttpResponse 是resp的父类，则支持关闭  
	        if(CloseableHttpResponse.class.isAssignableFrom(resp.getClass())){  
	            ((CloseableHttpResponse)resp).close();  
	        }  
	    } catch (IOException e) {  
	        logger.error("",e);  
	    }  
	} 
	/**
	 * 判断url是http还是https，直接返回相应的默认client对象
	 * 
	 * @return						返回对应默认的client对象
	 * @throws HttpProcessException 
	 */
	private static HttpClient create(String url) throws Exception  {
		if(url.toLowerCase().startsWith("https://")){
//			return  HttpClientBuilder.create().build();
			return  null;
		}else{
			return HttpClientBuilder.create().build();
		}
	}
	
	public static String send(String url) throws Exception {  
	    return send(url, Charset.defaultCharset().name());  
	}  
	public static String send(String url, String encoding) throws Exception {  
	    return send(url, new Header[]{},encoding);  
	}  
	public static String send(String url, Header[] headers) throws Exception {  
	    return send(url, headers, Charset.defaultCharset().name());  
	}  
	public static String send(String url, Header[] headers, String encoding) throws Exception {  
	    return send(url, new HashMap<String,String>(), headers, encoding);  
	}  
	public static String send(String url, Map<String,String>parasMap) throws Exception {  
	    return send(url, parasMap, Charset.defaultCharset().name());  
	}  
	public static String send(String url, Map<String,String>parasMap, String encoding) throws Exception {  
	    return send(url, parasMap, new Header[]{}, encoding);  
	}  
	public static String send(String url, Map<String,String>parasMap, Header[] headers) throws Exception {  
	    return send(url, parasMap, headers, Charset.defaultCharset().name());  
	}  
	// 有用
	public static String send(String url, Map<String,String>parasMap, Header[] headers, String encoding) throws Exception {  
	    return send(url, HttpMethods.POST, parasMap, headers, encoding);  
	}     
	public static String send(String url, HttpMethods httpMethod) throws Exception {  
	    return send(url, httpMethod, Charset.defaultCharset().name());  
	}  
	public static String send(String url, HttpMethods httpMethod, String encoding) throws Exception {  
	    return send(url, httpMethod, new Header[]{},encoding);  
	}  
	public static String send(String url, HttpMethods httpMethod, Header[] headers) throws Exception {  
	    return send(url, httpMethod, headers, Charset.defaultCharset().name());  
	}  
	public static String send(String url, HttpMethods httpMethod, Header[] headers, String encoding) throws Exception {  
	    return send(url, httpMethod, new HashMap<String, String>(), headers, encoding);  
	}  
	public static String send(String url, HttpMethods httpMethod, Map<String,String>parasMap) throws Exception {  
	    return send(url, httpMethod, parasMap, Charset.defaultCharset().name());  
	}  
	public static String send(String url, HttpMethods httpMethod, Map<String,String>parasMap, String encoding) throws Exception {  
	    return send(url, httpMethod, parasMap, new Header[]{}, encoding);  
	}  
	//有用
	public static String send(String url, HttpMethods httpMethod, Map<String,String>parasMap, Header[] headers) throws Exception {  
	    return send(url, httpMethod, parasMap, headers, Charset.defaultCharset().name());  
	}
	
	public static String send(String url, HttpMethods httpMethod, Map<String,String>parasMap, Header[] headers, String encoding) throws Exception {  
	    return send(create(url), url, httpMethod, parasMap, headers, encoding);  
	}  
	  
	public static String send(HttpClient client, String url) throws Exception {  
	    return send(client, url, Charset.defaultCharset().name());  
	}  
	public static String send(HttpClient client, String url, String encoding) throws Exception {  
	    return send(client, url, new Header[]{}, encoding);  
	}  
	public static String send(HttpClient client, String url, Header[] headers) throws Exception {  
	    return send(client, url, headers, Charset.defaultCharset().name());  
	}  
	public static String send(HttpClient client, String url, Header[] headers, String encoding) throws Exception {  
	    return send(client, url, new HashMap<String, String>(), headers, encoding);  
	}  
	public static String send(HttpClient client, String url, Map<String,String>parasMap) throws Exception {  
	    return send(client, url, parasMap, Charset.defaultCharset().name());  
	}  
	public static String send(HttpClient client, String url, Map<String,String>parasMap, String encoding) throws Exception {  
	    return send(client, url, parasMap, new Header[]{}, encoding);  
	}  
	public static String send(HttpClient client, String url, Map<String,String>parasMap, Header[] headers) throws Exception {  
	    return send(client, url, parasMap, headers, Charset.defaultCharset().name());  
	}  
	public static String send(HttpClient client, String url, Map<String,String>parasMap,Header[] headers,String encoding) throws Exception {  
	    return send(client, url, HttpMethods.POST, parasMap, headers, encoding);  
	}  
	public static String send(HttpClient client, String url, HttpMethods httpMethod) throws Exception {  
	    return send(client, url, httpMethod, Charset.defaultCharset().name());  
	}  
	public static String send(HttpClient client, String url, HttpMethods httpMethod, String encoding) throws Exception {  
	    return send(client, url, httpMethod, new Header[]{}, encoding);  
	}  
	public static String send(HttpClient client, String url, HttpMethods httpMethod, Header[] headers) throws Exception {  
	    return send(client, url, httpMethod, headers, Charset.defaultCharset().name());  
	}  
	public static String send(HttpClient client, String url, HttpMethods httpMethod, Header[] headers, String encoding) throws Exception {  
	    return send(client, url, httpMethod, new HashMap<String, String>(), headers, encoding);  
	}  
	public static String send(HttpClient client, String url, HttpMethods httpMethod, Map<String,String>parasMap) throws Exception {  
	    return send(client, url, httpMethod, parasMap, Charset.defaultCharset().name());  
	}  
	public static String send(HttpClient client, String url, HttpMethods httpMethod, Map<String,String>parasMap, String encoding) throws Exception {  
	    return send(client, url, httpMethod, parasMap, new Header[]{}, encoding);  
	}  
	public static String send(HttpClient client, String url, HttpMethods httpMethod, Map<String,String>parasMap, Header[] headers) throws Exception {  
	    return send(client, url, httpMethod, parasMap, headers, Charset.defaultCharset().name());  
	}  
}
