package com.java.collection.linkedList;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 类MyLinkedList.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年10月17日 上午11:49:21
 * @version 1.0.0
 */
public class MyLinkedList {
    /**
     * peek()和element()方法 返回队头,不移除
     * 。但当队列没有值时peek()方法返回Null,而element方法返回NoSuchElementException 异常；
     * poll（）和remove
     * （）方法讲移除并返回队头，poll在队列为空时返回Null,remove会抛出NoSuchElementException异常
     * 
     * @param queue
     */
    public static void pringtQueue(Queue queue) {
        while (queue.peek() != null) {
            System.out.print(queue.remove());
            //            System.out.print(queue.poll());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < 10; i++) {
            queue.offer(i);
        }
        pringtQueue(queue);
        System.out.println("affter:" + queue.size());
        System.out.println("poll:" + queue.poll());
        System.out.println("remove:" + queue.remove());
        Queue<Character> qc = new LinkedList<Character>();
        for (char c : "Brontosaurs".toCharArray()) {
            qc.offer(c);
        }
        pringtQueue(qc);
    }
}
