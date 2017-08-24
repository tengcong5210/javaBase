package com.java.thread.concurrencyOfArt.chap5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.PriorityQueue;

/**
 * 使用Object.wait和Object.notify实现生产者消费者
 * 作业：将此示例通过阻塞队列进行实现一遍
 * @author tengcongcong
 * @create 2017-08-24 9:44
 * @Version 1.0
 **/
public class ObjectProducerConsumerCase {

   private static final Logger LOGGER= LoggerFactory.getLogger(ObjectProducerConsumerCase.class);

   private int queueSize=10;
   //非阻塞队列
   private PriorityQueue<Integer> queue=new PriorityQueue<Integer>(queueSize);

   public static void main(String[] args){
       ObjectProducerConsumerCase producerConsumerCase=new ObjectProducerConsumerCase();
       Producer producer=producerConsumerCase.new Producer();
       Consumer consumer=producerConsumerCase.new Consumer();

       producer.start();
       consumer.start();
   }
   //消费者-线程
   class Consumer extends Thread{
       @Override
       public void run() {
           consume();
       }
       private void consume() {
            while (true){
                synchronized (queue){
                    while (queue.size()==0){
                        LOGGER.info("队列空,等待数据");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    queue.poll();//每次移走队首元素
                    queue.notify();
                    LOGGER.info("从队列取走一个元素,队列剩余:{}个元素",queue.size());
                }
            }
       }
   }
   //生产者-线程
   class Producer extends Thread{
       @Override
       public void run() {
           produce();
       }

       private void produce() {
            while (true){
                synchronized (queue){
                    while (queue.size()==queueSize){
                        try {
                            LOGGER.info("队列满，等待有空余空间");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    queue.offer(1);//每次插入一个元素
                    queue.notify();
                    LOGGER.info("向队列中插入一个元素，队列剩余空间:{}",(queueSize-queue.size()));
                }
            }
       }
   }
}
