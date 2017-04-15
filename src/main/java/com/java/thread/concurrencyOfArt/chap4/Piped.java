package com.java.thread.concurrencyOfArt.chap4;

import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 管道输入/输出
 * Created by ibm on 2017/4/15.
 */
public class Piped {
    public static void main(String[] args) throws Exception {
        PipedWriter out=new PipedWriter();
        PipedReader in=new PipedReader();
        //将输出流和输入流进行连接、否则在使用时会抛出IoException
        out.connect(in);

        Thread printThread=new Thread(new Print(in),"PrintThread");
        printThread.start();

        int receive=0;
        try {
            while ((receive=System.in.read())!=-1){
                out.write(receive);
            }
        }finally {
            out.close();
        }
    }

    static class Print implements Runnable{

        private PipedReader in;
        public Print(PipedReader in){
            this.in=in;
        }

        public void run() {
            int receive=0;
            try {
                while ((receive=in.read())!=-1){
                    System.out.print((char) receive);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
