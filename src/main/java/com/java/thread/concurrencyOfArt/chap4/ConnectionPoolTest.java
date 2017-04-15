package com.java.thread.concurrencyOfArt.chap4;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试数据库连接池
 * 注:CountDownLatch工具类的用法要掌握
 * CountDownLatch类是一个同步计数器,构造时传入int参数,该参数就是计数器的初始值，
 * 每调用一次countDown()方法，计数器减1,计数器大于0 时，await()方法会阻塞程序继续执行
 * Created by ibm on 2017/4/15.
 */
public class ConnectionPoolTest {
    static ConnectionPool pool=new ConnectionPool(10);
    //保证所有ConnectionRunner能够同时开始
    static CountDownLatch start=new CountDownLatch(1);
    //main线程将会等待所有ConnectionRunner结束后才能继续执行
    static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        //线程数量，可以修改线程数量进行观察
        int threadCount=10;
        end=new CountDownLatch(threadCount);
        int count=20;
        AtomicInteger got=new AtomicInteger();
        AtomicInteger notGot=new AtomicInteger();
        for (int i=0;i<threadCount;i++){
            Thread thread=new Thread(new ConnectionRunner(count,got,notGot),"ConnectionRunnerThread_"+i);
            thread.start();
        }
        System.out.println(Thread.currentThread().getName()+" is run here");
        start.countDown();
        end.await();
        System.out.println("total invoke:"+(threadCount*count));
        System.out.println("got connection:"+got);
        System.out.println("not got connection:"+notGot);
    }

    static class ConnectionRunner implements Runnable{
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnectionRunner(int count,AtomicInteger got,AtomicInteger notGot){
            this.count=count;
            this.got=got;
            this.notGot=notGot;
        }

        public void run() {
            try {
                System.out.println(Thread.currentThread().getName()+" is await");
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (count>0){
                try {
                    Connection connection=pool.fetchConnection(1000);

                    if(connection!=null){
                        try {
                            connection.createStatement();
                            connection.commit();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    }else {
                        notGot.incrementAndGet();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    count--;
                }
            }
            end.countDown();
        }
    }

}
