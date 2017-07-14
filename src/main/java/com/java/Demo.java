package com.java;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Demo {
	public static void main(String[] args) {
		String url = "http://116.228.49.130:8103/p2p/payment";
		//int connectTimeout = 15000;
		//int readTimeout = 3000;
		String result = null;
		CloseableHttpClient httpClient = null;
		HttpPost httpPost = null;
		try {
			
			String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALOUQa+uF6zsBQ6s6A1S+ckIJRk46aI00FH/T0uUgnKY+bh4n3abwya5hg3ikwd64n1XX/lwVZ9Dow8QhM/kkVAIOA6enLNlwjpVE3KyMXB0SLmxwFSi4Im4e0DD5L2CnfXQmftuFxdk/Li46jXdmCQc4YM4iEX1iVZaBAGW1glbAgMBAAECgYBVYGkSUxyic9u7rGzu2MI015B7u1koax+XvGBAuKyEO0KOd5qo00kmwhF/zHbGmZ/Qo5fXiZbLj2aYpOvfwvVqYIjl5C/Y1jiznsBhmfYLLVQKDzPNIUUE5F0nNOU7GxceONlPrVMHoulWblAKVhq3CMxI6R5RFGFVVyEBKphnMQJBAOwzQ6SHbx6tFamjmWL3F/4f3rPpMawUkqmAvyAA51lLdXnf5/gamKIU9i+yd7gIZPagUjMFv1ggvax/dDCUNAcCQQDCoe6khZcMB0aOx2GYyDrSnVVJnHhjHiReHdK3lrxgWjrtvoZeBagSpMVADpMG6A+0d05CdsI1mhOayDO2/jMNAkBBXQ5jAXemrY9JGpTf5jElifw/HVE5pZfQgGhjmtxqwY8I4wV2iyWh9NsL5/9pViladpNIu1ZwNN9IVRz6NIkRAkBNgA12lXs/3uXJlLrYC2Lg2qVLWnLVhPsWPunZELyR4Vv1rxfx+G6kfdfNWgBRj7YxNhCDhqZukZuc1ntBMpdBAkEAzfENknpHm+0LYQnA4PPkrmxs/juOelip3hWpd+aGSsOw3ocpCLqXK3o+cpn7wuEOw6YsGGeJmhbHgz1BCEEQuA==";
			String orgId = "shitou";
			String timestamp = String.valueOf(new Date().getTime());
			String applyId = "20170707103234138340";
			byte[] bytes = RSAUtils
					.generateSHA1withRSASigature("P2PID" + orgId + "APPLYID"
							+ applyId + "TIMESTAMP" + timestamp, privateKey);
			String sign = Base64Utils.encode(bytes);

			Map<String, String> params = new HashMap<String, String>();
			params.put("orgId", orgId);
			params.put("timestamp", timestamp);
			params.put("applyId", applyId);
			params.put("sign", sign);

			/*String content = JSONObject.fromObject(params).toString();*/
			String content = JSONObject.toJSONString(params);

			httpClient = HttpClients.createDefault();
			httpPost = new HttpPost(url);

			httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");

			StringEntity stringEntity = new StringEntity(content, "UTF-8");
			stringEntity.setContentEncoding(new BasicHeader(
					HTTP.CONTENT_ENCODING, "UTF-8"));

			httpPost.setEntity(stringEntity);

			HttpResponse response = httpClient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == 200) {
				// 获取响应实体
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					result = EntityUtils.toString(entity, "UTF-8");
					System.out.println(result);

				}
			}

		} catch (Exception e) {

		} finally {
			if (httpPost != null) {
				httpPost.releaseConnection();
			}
			if (httpClient != null) {
				try {
					httpClient.close();
				} catch (Exception e) {

				}
			}

		}
	}

}
