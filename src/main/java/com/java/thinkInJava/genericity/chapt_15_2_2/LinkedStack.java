package com.java.thinkInJava.genericity.chapt_15_2_2;

/**
 * 不用LinkedList实现栈的方式:首先要了解栈的特点。即（先进后出）first in last out
 * 
 * @author tengcongcong
 * @date 2015年11月29日 下午9:55:09
 * @version 1.0.0
 */
public class LinkedStack<T> {
    //静态内部类
    private static class Node<U> {
        U       item;
        Node<U> next;

        Node() {
            item = null;
            next = null;
        }

        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }

    }

    //静态内部类的实例，调用的是无参构造函数
    private Node<T> top = new Node<T>();

    public void push(T item) {
        top = new Node<T>(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack<String>();
        lss.push("Hello");
        lss.push("Word");
        lss.pop();
    }
}
