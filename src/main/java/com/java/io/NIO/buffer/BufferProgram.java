package com.java.io.NIO.buffer;

import java.io.FileInputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by ibm on 2017/9/12.
 */
public class BufferProgram {
    public static void main(String[] args){
        try {


            FileInputStream fin=new FileInputStream("d://mywork//nio-data.txt");
            FileChannel fc=fin.getChannel();
            ByteBuffer buffer=ByteBuffer.allocate(10);
            output("初始化",buffer);

            fc.read(buffer);
            output("调用read()",buffer);

            buffer.flip();
            output("调用flip",buffer);
            while (buffer.remaining()>0){
                Byte b=buffer.get();
            }

            output("调用get()",buffer);

            buffer.clear();

            fin.close();



        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void output(String step, Buffer buffer){
        System.out.println(step+":");
        System.out.print("capacity:"+buffer.capacity()+",");
        System.out.print("position:"+buffer.position()+",");
        System.out.println("limit:"+buffer.limit()+",");
        System.out.println("=====================================");

    }
}
