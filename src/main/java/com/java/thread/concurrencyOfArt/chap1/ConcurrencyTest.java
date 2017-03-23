package com.java.thread.concurrencyOfArt.chap1;

/**
 * 多线程一定快吗
 * Created by ibm on 2017/3/23.
 */
public class ConcurrencyTest {
    private static final long count=100000000l;
    //并发执行
    private static void concurrency() throws InterruptedException {
        long start=System.currentTimeMillis();
        Thread thread=new Thread(new Runnable() {
            public void run() {
                int a=0;
                for(long i=0;i<count;i++){
                    a+=5;
                }
            }
        });
        thread.start();
        int b=0;
        for (long i=0;i<count;i++){
            b--;
        }
        //join()的作用其实java doc 说的很清楚了:Waits for this thread to die.翻译过来就是等待这个线程死亡,
        // 如果join的线程不死亡,程序就会阻塞在那里.
        thread.join();
        long time=System.currentTimeMillis()-start;
        System.out.println("concurrency :"+time+"ms,b="+b);
    }
    //串行
    private static void serial(){
        long start=System.currentTimeMillis();
        int a=0;
        for(long i=0;i<count;i++){
            a+=5;
        }
        int b=0;
        for (long i=0;i<count;i++){
            b--;
        }
        long time=System.currentTimeMillis()-start;
        System.out.println("serial:"+time+"ms,b="+b+",a="+a);
    }
    public static void main(String[] args) throws InterruptedException {
         // 10000  concurrency=1ms serial=1ms
        // 100000  concurrency=2ms serial=3ms
        // 1000000  concurrency=5ms serial=6ms
        // 10000000  concurrency=10ms serial=14ms
        // 100000000  concurrency=47ms serial=90ms
        //结论：当并发执行累加操作不超过百万次时，速度会比串行执行累加操作要慢
        concurrency();
        serial();

    }
}
