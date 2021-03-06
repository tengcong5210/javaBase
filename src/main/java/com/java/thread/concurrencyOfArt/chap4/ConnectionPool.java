package com.java.thread.concurrencyOfArt.chap4;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * 数据库连接池示例
 * Created by ibm on 2017/4/15.
 */
public class ConnectionPool {
    //通过双向队列存储连接
   private LinkedList<Connection> pool=new LinkedList<Connection>();
   //初始化连接池
   public ConnectionPool(int initialSize){
        if(initialSize>0){
            for (int i=0;i<initialSize;i++){
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
   }

    /**
     * 释放连接
     * @param connection
     */
   public void releaseConnection(Connection connection){
       if(connection!=null){
           synchronized (pool){
               //连接释放后需要进行通知，这样其他消费者能够感知到连接池中已经归还了一个连接
               pool.addLast(connection);
               pool.notifyAll();
           }
       }
   }

    /**
     * 获取连接
     * @param mills
     * @return
     */
   public Connection fetchConnection(long mills) throws InterruptedException {
       synchronized (pool){
           if(mills<=0){
               while (pool.isEmpty()){
                   pool.wait();
               }
               return pool.removeFirst();
           }else {
                long future=System.currentTimeMillis()+mills;
                long remaining=mills;
                while (pool.isEmpty()&&remaining>0){
                    pool.wait(remaining);
                    remaining=future-System.currentTimeMillis();
                }
                Connection result=null;
                if(!pool.isEmpty()){
                    result=pool.removeFirst();
                }
               return result;
           }
       }

   }
}
