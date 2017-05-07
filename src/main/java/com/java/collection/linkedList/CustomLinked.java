package com.java.collection.linkedList;

/**
 * 自定义一个Linked
 * Created by ibm on 2017/5/7.
 */
public class CustomLinked<E> {

    int size=0;
    //首节点
    Node<E> first;
    //尾节点
    Node<E> last;

    public CustomLinked(){
        System.out.println("默认构造函数");
    }

    public boolean add(E e){
        linkLast(e);
        return true;
    }

    private void linkLast(E e){
        final Node<E> l=last;
        final Node<E> newNode=new Node<E>(l,e,null);
        last=newNode;
        if(l==null){
            first=newNode;
        }else{
            l.next=newNode;
        }
        size++;

    }


    //静态内部类-存储节点(链表结构)
    private static class Node<E>{
        //当前元素
        E item;
        //下一个节点
        Node<E> next;
        //前一个节点
        Node<E> prev;

        Node(Node<E> prev,E element,Node<E> next){
            this.item=element;
            this.next=next;
            this.prev=prev;
        }
    }
}
