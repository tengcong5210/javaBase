package com.java.http;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.protocol.Protocol;

import sun.misc.BASE64Encoder;

/**
 * http请求工具类
 */
public class HttpClientUtil {
    //    private final static Logger                       logger                = LoggerFactory
    //                                                                                    .getLogger(HttpClientUtil.class);

    //  private static final HttpClient client         = new HttpClient(new SimpleHttpConnectionManager());
    private static MultiThreadedHttpConnectionManager httpConnectionManager = new MultiThreadedHttpConnectionManager();
    private static HttpClient                         client;
    static {
        //每主机最大连接数
        Protocol myhttps = new Protocol("https", new MySecureProtocolSocketFactory(), 443);
        Protocol.registerProtocol("https", myhttps);
        client = new HttpClient(httpConnectionManager);
        client.getHttpConnectionManager().getParams().setDefaultMaxConnectionsPerHost(32);
        //总最大连接数
        client.getHttpConnectionManager().getParams().setMaxTotalConnections(256);
        //超时时间 3sec
        client.getHttpConnectionManager().getParams().setConnectionTimeout(6000);
        client.getHttpConnectionManager().getParams().setSoTimeout(6000);
        //client.getHttpConnectionManager().getParams().setTcpNoDelay(true);
        //client.getHttpConnectionManager().getParams().setLinger(1000);

    }

    public static HttpClient getHttpClient() {
        return client;
    }

    /**
     * 用法： HttpRequestProxy hrp = new HttpRequestProxy();
     * hrp.doRequest("http://www.163.com",null,null,"utf-8");
     * 
     * @param url 请求的资源ＵＲＬ
     * @param postData POST请求时form表单封装的数据 没有时传null
     * @param header request请求时附带的头信息(header) 没有时传null
     * @param encoding response返回的信息编码格式 没有时传null
     * @return response返回的文本数据
     * @throws Exception
     */
    public static String doRequest(String url, Map postData, Map header, String encoding) throws Exception {
        String responseString = null;
        //头部请求信息  
        Header[] headers = initHeader(header);
        if (postData != null) {
            //post方式请求
            responseString = executePost(url, postData, encoding, headers);
        } else {
            //get方式 请求
            responseString = executeGet(url, encoding, headers);
        }

        return responseString;
    }

    public static String doRequest(String url) throws Exception {
        String responseString = null;
        //get方式 请求
        responseString = executeGet(url);

        return responseString;
    }

    //get方式 请求
    private static String executeGet(String url) throws Exception {
        String responseString = "";
        GetMethod getRequest = new GetMethod(url.trim());

        try {
            responseString = executeMethod(getRequest);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            getRequest.releaseConnection();
        }
        return responseString;
    }

    //get方式 请求
    private static String executeGet(String url, String encoding, Header[] headers) throws Exception {
        String responseString = "";
        GetMethod getRequest = new GetMethod(url.trim());
        if (headers != null) {
            for (int i = 0; i < headers.length; i++) {
                getRequest.setRequestHeader(headers[i]);
            }
        }
        try {

            responseString = executeMethod(getRequest, encoding);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            getRequest.releaseConnection();
        }
        return responseString;
    }

    //post方式请求
    private static String executePost(String url, Map postData, String encoding, Header[] headers) throws Exception {
        String responseString = "";
        PostMethod postRequest = new PostMethod(url.trim());
        if (headers != null) {
            for (int i = 0; i < headers.length; i++) {
                postRequest.setRequestHeader(headers[i]);
            }
        }
        Set entrySet = postData.entrySet();
        int dataLength = entrySet.size();
        NameValuePair[] params = new NameValuePair[dataLength];
        int i = 0;
        for (Iterator itor = entrySet.iterator(); itor.hasNext();) {
            Map.Entry entry = (Map.Entry) itor.next();
            params[i++] = new NameValuePair(entry.getKey().toString(), entry.getValue().toString());
        }
        postRequest.setRequestBody(params);
        try {

            responseString = executeMethod(postRequest, encoding);

        } catch (Exception e) {
            throw e;
        } finally {
            postRequest.releaseConnection();
        }
        return responseString;
    }

    //请求头部信息
    private static Header[] initHeader(Map header) {
        Header[] headers = null;
        if (header != null) {
            Set entrySet = header.entrySet();
            int dataLength = entrySet.size();
            headers = new Header[dataLength];
            int i = 0;
            for (Iterator itor = entrySet.iterator(); itor.hasNext();) {
                Map.Entry entry = (Map.Entry) itor.next();
                headers[i++] = new Header(entry.getKey().toString(), entry.getValue().toString());
            }
        }
        return headers;
    }

    //调用并获取返回
    private static String executeMethod(HttpMethod request, String encoding) throws Exception {
        String responseContent = null;
        InputStream responseStream = null;
        BufferedReader rd = null;
        try {
            Long start = System.currentTimeMillis();

            int status = getHttpClient().executeMethod(request);

            if (encoding != null) {
                responseStream = request.getResponseBodyAsStream();
                rd = new BufferedReader(new InputStreamReader(responseStream, encoding));
                String tempLine = rd.readLine();
                StringBuffer tempStr = new StringBuffer();
                String crlf = System.getProperty("line.separator");
                while (tempLine != null) {
                    tempStr.append(tempLine);
                    tempStr.append(crlf);
                    tempLine = rd.readLine();
                }
                responseContent = tempStr.toString();
            } else {
                responseContent = request.getResponseBodyAsString();
            }
            Header locationHeader = request.getResponseHeader("location");
            //返回代码为302,301时，表示页面己经重定向，则重新请求location的url，这在  
            //一些登录授权取cookie时很重要
            //TODO 如果需要处理重定向请求，请在下面代码中改造
            if (locationHeader != null) {
                //String redirectUrl = locationHeader.getValue();
                //doRequest(redirectUrl, null, null, null);
            }
        } catch (HttpException e) {
            throw e;
        } catch (IOException e) {
            throw e;

        } finally {
            if (rd != null)
                try {
                    rd.close();
                } catch (IOException e) {
                    throw e;
                }
            if (responseStream != null)
                try {
                    responseStream.close();
                } catch (IOException e) {
                    throw e;

                }
        }
        return responseContent;
    }

    //调用并获取返回
    @SuppressWarnings("unused")
    private static String executeMethod(HttpMethod request) throws Exception {
        String responseContent = null;
        InputStream responseStream = null;
        ByteArrayOutputStream out = null;
        BASE64Encoder base64 = new BASE64Encoder();
        try {
            Long start = System.currentTimeMillis();

            int status = getHttpClient().executeMethod(request);

            responseStream = request.getResponseBodyAsStream();
            out = new ByteArrayOutputStream(1024);

            byte[] tempbytes = new byte[1024];
            int byteread = 0;
            while ((byteread = responseStream.read(tempbytes)) != -1) {
                out.write(tempbytes, 0, byteread);
            }
            byte[] bytes = out.toByteArray();
            responseContent = base64.encode(bytes);
            //            responseContent = Base64.encodeBase64String(bytes);//base64加密
            Header locationHeader = request.getResponseHeader("location");
            //返回代码为302,301时，表示页面己经重定向，则重新请求location的url，这在  
            //一些登录授权取cookie时很重要
            //TODO 如果需要处理重定向请求，请在下面代码中改造
            if (locationHeader != null) {
                //String redirectUrl = locationHeader.getValue();
                //doRequest(redirectUrl, null, null, null);
            }
        } catch (HttpException e) {
            throw e;
        } catch (IOException e) {
            throw e;

        } finally {
            if (responseStream != null) {
                responseStream.close();
            }
            if (out != null) {
                out.close();
            }
        }
        return responseContent;
    }

    /**
     * 特殊请求数据,这样的请求往往会出现redirect本身而出现递归死循环重定向 所以单独写成一个请求方法
     * 比如现在请求的url为：http://localhost:8080/demo/index.jsp 返回代码为302
     * 头部信息中location值为:http://localhost:8083/demo/index.jsp
     * 这时httpclient认为进入递归死循环重定向，抛出CircularRedirectException异常
     * 
     * @param url
     * @return
     * @throws Exception
     */
    public String doSpecialRequest(String url, int count, String encoding) throws Exception {
        String str = null;
        InputStream responseStream = null;
        BufferedReader rd = null;
        GetMethod getRequest = new GetMethod(url);
        //关闭httpclient自动重定向动能  
        getRequest.setFollowRedirects(false);
        try {

            client.executeMethod(getRequest);
            Header header = getRequest.getResponseHeader("location");
            if (header != null) {
                //请求重定向后的ＵＲＬ，count同时加1  
                this.doSpecialRequest(header.getValue(), count + 1, encoding);
            }
            //这里用count作为标志位，当count为0时才返回请求的ＵＲＬ文本,  
            //这样就可以忽略所有的递归重定向时返回文本流操作，提高性能  
            if (count == 0) {
                getRequest = new GetMethod(url);
                getRequest.setFollowRedirects(false);
                client.executeMethod(getRequest);
                responseStream = getRequest.getResponseBodyAsStream();
                rd = new BufferedReader(new InputStreamReader(responseStream, encoding));
                String tempLine = rd.readLine();
                StringBuilder tempStr = new StringBuilder();
                String crlf = System.getProperty("line.separator");
                while (tempLine != null) {
                    tempStr.append(tempLine);
                    tempStr.append(crlf);
                    tempLine = rd.readLine();
                }
                str = tempStr.toString();
            }

        } catch (HttpException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        } finally {
            getRequest.releaseConnection();
            if (rd != null)
                try {
                    rd.close();
                } catch (IOException e) {
                    throw e;
                }
            if (responseStream != null)
                try {
                    responseStream.close();
                } catch (IOException e) {
                    throw e;
                }
        }
        return str;
    }
}
