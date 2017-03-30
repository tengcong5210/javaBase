package com.java.thread.concurrencyOfArt.chap3;

/**
 * Volatile变量使用
 * 注意：此类的方法可以通过使用synchronized来改写
 * 总结：volatile对单个volatile变量的读写具有原子性，而锁的互斥执行的特性可以确保对整个临界区代码的执行
 * 具有原子性。在功能上，锁比volatile更强大；在可伸缩性和执行性能上，volatile更有优势.
 * Created by ibm on 2017/3/28.
 */
public class VolatileFeaturesExample {
    //使用volatile声明64位的long型变量
    volatile long vl=0L;
    //单个volatile变量的写
    public void set (long l){
        vl=l;
    }
    //复合volatile变量的读/写
    public void getAndIncrement(){
        vl++;
    }
    //单个volatile变量的读
    public long get(){
        return vl;
    }

    public static void main(String[] args){
        System.out.println("开始");
        final  VolatileFeaturesExample vfe=new VolatileFeaturesExample();
        Thread t1=new Thread(new Runnable() {
            public void run() {
                vfe.getAndIncrement();
                System.out.println("t1:"+vfe.get());
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            public void run() {
                vfe.getAndIncrement();
                System.out.println("t2:"+vfe.get());
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3=new Thread(new Runnable() {
            public void run() {
                vfe.getAndIncrement();
                System.out.println("t3:"+vfe.get());
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
        System.out.println("结束");


    }
}
//如示例所示，一个volatile变量的单个读/写操作，与一个普通变量的读/写操作都是使用同一个锁来同步的。
// 他们之间的执行效果相同
class VolatileFeaturesExample2{
    long vl=0;

    public synchronized void set(long l){
        vl=l;
    }

    public void getAndIncrement(){
        long temp=get();
        temp+=1L;
        set(temp);
    }

    public synchronized long get(){
        return vl;
    }
}
