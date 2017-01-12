package com.java.http.examples;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

/**
 * 创建HttpReqHead
 * @author tcc
 *
 */
public class HttpHeader {
	/**
	 * 返回header头信息
	 * 
	 * @return
	 */
	public static Header[] getHeaders(Map<String, Header> headerMaps ) {
		Header[] headers = new Header[headerMaps.size()];
		int i = 0;
		for (Header header : headerMaps.values()) {
			headers[i] = header;
			i++;
		}
		headerMaps.clear();
		headerMaps = null;
		return headers;
	}

	/**
	 * Http头信息
	 * 
	 * @author arron
	 * @date 2015年11月9日 上午11:29:04
	 * @version 1.0
	 */
	public static class HttpReqHead {
		public static final String ACCEPT = "Accept";
		public static final String ACCEPT_CHARSET = "Accept-Charset";
		public static final String ACCEPT_ENCODING = "Accept-Encoding";
		public static final String ACCEPT_LANGUAGE = "Accept-Language";
		public static final String ACCEPT_RANGES = "Accept-Ranges";
		public static final String AUTHORIZATION = "Authorization";
		public static final String CACHE_CONTROL = "Cache-Control";
		public static final String CONNECTION = "Connection";
		public static final String COOKIE = "Cookie";
		public static final String CONTENT_LENGTH = "Content-Length";
		public static final String CONTENT_TYPE = "Content-Type";
		public static final String DATE= "Date";
		public static final String EXPECT = "Expect";
		public static final String FROM = "From";
		public static final String HOST = "Host";
		public static final String IF_MATCH = "If-Match ";
		public static final String IF_MODIFIED_SINCE = "If-Modified-Since";
		public static final String IF_NONE_MATCH = "If-None-Match";
		public static final String IF_RANGE = "If-Range";
		public static final String IF_UNMODIFIED_SINCE = "If-Unmodified-Since";
		public static final String KEEP_ALIVE = "Keep-Alive";
		public static final String MAX_FORWARDS = "Max-Forwards";
		public static final String PRAGMA = "Pragma";
		public static final String PROXY_AUTHORIZATION = "Proxy-Authorization";
		public static final String RANGE = "Range";
		public static final String REFERER = "Referer";
		public static final String TE = "TE";
		public static final String UPGRADE = "Upgrade";
		public static final String USER_AGENT = "User-Agent";
		public static final String VIA = "Via";
		public static final String WARNING = "Warning";
	}
	
	/**
	 * 常用头信息配置
	 * 
	 * @author arron
	 * @date 2015年11月18日 下午5:30:00 
	 * @version 1.0
	 */
	public static class Headers{
		public static final String APP_FORM_URLENCODED="application/x-www-form-urlencoded";
		public static final String TEXT_PLAIN="text/plain";
		public static final String TEXT_HTML="text/html";
		public static final String TEXT_XML="text/xml";
		public static final String TEXT_JSON="text/json";
		public static final String CONTENT_CHARSET_ISO_8859_1 = Consts.ISO_8859_1.name();
		public static final String CONTENT_CHARSET_UTF8 = Consts.UTF_8.name();
		public static final String DEF_PROTOCOL_CHARSET = Consts.ASCII.name();
		public static final String CONN_CLOSE = "close";
		public static final String KEEP_ALIVE = "keep-alive";
		public static final String EXPECT_CONTINUE = "100-continue";
	}
}
