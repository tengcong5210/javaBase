package com.java.io;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 类RemoteReadFile.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年12月2日 下午10:32:40
 * @version 1.0.0
 */
public class RemoteReadFile {

    /**
     * 通过HTTP方式获取文件
     * 
     * @param strUrl
     * @param fileName
     * @return
     * @throws IOException
     */
    private static boolean getRemoteFile(String strUrl, String fileName) throws IOException {
        URL url = new URL(strUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        DataInputStream input = new DataInputStream(conn.getInputStream());
        DataOutputStream output = new DataOutputStream(new FileOutputStream(fileName, true));
        //        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true)));
        byte[] buffer = new byte[1024 * 8];
        int count = 0;
        while ((count = input.read(buffer)) > 0) {
            output.write(buffer, 0, count);
        }
        output.close();
        input.close();
        return true;
    }

    public static void main(String[] args) throws Exception {
        //        String fileUrl = "http://test-ygd.wjs.com/web/getFileStream?filePath=/ygd/20151201/2000000000003375_inc_e195490fcf404e8796e0ebccb61083da.JPG";
        String fileUrl = "http://wjsprd.oss-cn-hzjbp-a-internal.aliyuncs.com/";

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(
                "D:\\12month_repmentInfo_url.txt")));
        String line = null;
        String fileName = "D:\\RepaymentInfo_18_12month.txt";
        while ((line = br.readLine()) != null) {

            String url = fileUrl + line;
            System.out.println("url:" + url);
            boolean bool = getRemoteFile(url, fileName);
            System.out.println("bool:" + bool);
        }
        br.close();

        //        boolean bool = getRemoteFile(fileUrl, "D:\\RepaymentInfo_18_12month.txt");
        //        System.out.println("bool:" + bool);

    }
}
