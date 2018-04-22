package com.java.io.NIO.Channel;

import org.junit.Test;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by ibm on 2017/9/10.
 */
public class FileOutputChannel {

    private static final byte[] message={11,98,80,70,60,50};

    //所以使用NIO 读取数据可以分为下面三个步骤：
    //1. 从FileInputStream 获取Channel
    //2. 创建Buffer
    //3. 将数据从Channel 读取到Buffer 中
    @Test
    public void testOutputChannel()throws  Exception{
        FileOutputStream fout=new FileOutputStream("D://mywork//nio-data.txt");
        //获取通道
        FileChannel  fc=fout.getChannel();
        //创建缓冲区
        ByteBuffer buf=ByteBuffer.allocate(1024);
        for(int i=0;i<message.length;i++){
            buf.put(message[i]);
        }
        buf.flip();
        fc.write(buf);
        fout.close();

    }

}
