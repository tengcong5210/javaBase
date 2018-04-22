package com.java.io.NIO.buffer;

import java.nio.IntBuffer;

/**
 * Created by ibm on 2017/9/12.
 */
public class testIntBuffer {
    public static void main(String[] args){
        //分配新的Int缓冲区，参数为缓冲区容量
        //新缓冲区的当前位置将为零，其界限将为其容量。它将具有一个底层实现数组，其数组偏移量将为零
        IntBuffer buffer=IntBuffer.allocate(8);
        for(int i=0;i<buffer.capacity();++i){
            int j=2*(i+1);
            //将给定的整数写到缓冲区
            buffer.put(j);
        }
        //重设次缓冲区，将限制设置为当前位置，然后将当前位置设置为0
        buffer.flip();
        while (buffer.hasRemaining()){
            int j=buffer.get();
            System.out.print(j+"  ");
        }
    }
}
