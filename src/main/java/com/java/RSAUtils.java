package com.java;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * RSA相关工具类
 */
public class RSAUtils {

    /**
     * 私钥签名
     * @param src
     * @param priKey
     * @return
     */
    public static byte[] generateSHA1withRSASigature(String src, String priKey)
    {
        try
        {
            Signature sigEng = Signature.getInstance("SHA1withRSA");
            byte[] pribyte = Base64Utils.decode(priKey);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(pribyte);
            KeyFactory fac = KeyFactory.getInstance("RSA");
            RSAPrivateKey privateKey = (RSAPrivateKey) fac.generatePrivate(keySpec);
            sigEng.initSign(privateKey);
            sigEng.update(src.getBytes());
            byte[] signature = sigEng.sign();
            return signature;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
	 * 利用公钥验签
	 *
	 * @param publicKey
	 *            公钥
	 * @param stringData
	 *            数据字符串
	 * @param stringSign
	 *            签名
	 * @return 是否验签成功
	 * @throws Exception
	 */
    public static boolean verifyByPublicKey(String publicKey, String stringData, String stringSign)  throws Exception{
    	byte[] sign = Base64Utils.decode(stringSign);
		byte[] data = stringData.getBytes("UTF-8");
		byte[] keyBytes = Base64Utils.decode(publicKey);
		
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicK = keyFactory.generatePublic(keySpec);
		Signature signature = Signature.getInstance("SHA1WithRSA");
		signature.initVerify(publicK);
		signature.update(data);
		return signature.verify(sign);
    }
    
   
    public static void main(String[] args){
    	try{
    	String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCzlEGvrhes7AUOrOgNUvnJCCUZOOmiNNBR/09LlIJymPm4eJ92m8MmuYYN4pMHeuJ9V1/5cFWfQ6MPEITP5JFQCDgOnpyzZcI6VRNysjFwdEi5scBUouCJuHtAw+S9gp310Jn7bhcXZPy4uOo13ZgkHOGDOIhF9YlWWgQBltYJWwIDAQAB";
    	String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALOUQa+uF6zsBQ6s6A1S+ckIJRk46aI00FH/T0uUgnKY+bh4n3abwya5hg3ikwd64n1XX/lwVZ9Dow8QhM/kkVAIOA6enLNlwjpVE3KyMXB0SLmxwFSi4Im4e0DD5L2CnfXQmftuFxdk/Li46jXdmCQc4YM4iEX1iVZaBAGW1glbAgMBAAECgYBVYGkSUxyic9u7rGzu2MI015B7u1koax+XvGBAuKyEO0KOd5qo00kmwhF/zHbGmZ/Qo5fXiZbLj2aYpOvfwvVqYIjl5C/Y1jiznsBhmfYLLVQKDzPNIUUE5F0nNOU7GxceONlPrVMHoulWblAKVhq3CMxI6R5RFGFVVyEBKphnMQJBAOwzQ6SHbx6tFamjmWL3F/4f3rPpMawUkqmAvyAA51lLdXnf5/gamKIU9i+yd7gIZPagUjMFv1ggvax/dDCUNAcCQQDCoe6khZcMB0aOx2GYyDrSnVVJnHhjHiReHdK3lrxgWjrtvoZeBagSpMVADpMG6A+0d05CdsI1mhOayDO2/jMNAkBBXQ5jAXemrY9JGpTf5jElifw/HVE5pZfQgGhjmtxqwY8I4wV2iyWh9NsL5/9pViladpNIu1ZwNN9IVRz6NIkRAkBNgA12lXs/3uXJlLrYC2Lg2qVLWnLVhPsWPunZELyR4Vv1rxfx+G6kfdfNWgBRj7YxNhCDhqZukZuc1ntBMpdBAkEAzfENknpHm+0LYQnA4PPkrmxs/juOelip3hWpd+aGSsOw3ocpCLqXK3o+cpn7wuEOw6YsGGeJmhbHgz1BCEEQuA==";
    	byte[] bytes = generateSHA1withRSASigature("am=123456",privateKey);
    	String sign = Base64Utils.encode(bytes);
    	System.out.println("sign="+sign);
    	System.out.println(verifyByPublicKey(publicKey,"am=123456",sign));
    	}catch(Exception e){
    		
    	}
    }
    




}