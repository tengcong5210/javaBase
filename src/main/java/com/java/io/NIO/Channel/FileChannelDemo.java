package com.java.io.NIO.Channel;

import org.junit.Test;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by ibm on 2017/9/10.
 */
public class FileChannelDemo {
    @Test
    public void testFileChannel()throws Exception{
        RandomAccessFile accessFile=new RandomAccessFile("D://mywork//nio-data.txt","rw");
        //获取通道
        FileChannel inChannel=accessFile.getChannel();
        //创建缓冲区
        ByteBuffer buf=ByteBuffer.allocate(48);
        int byteRead=inChannel.read(buf);
        while (byteRead!=-1){
            System.out.println("Read:"+byteRead);
            buf.flip();
            while (buf.hasRemaining()){
                System.out.print((char) buf.get());
            }
            buf.clear();
            byteRead=inChannel.read(buf);

        }
        accessFile.close();

    }


}
