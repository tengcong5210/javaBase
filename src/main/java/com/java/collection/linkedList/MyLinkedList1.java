package com.java.collection.linkedList;

import java.io.Serializable;

public class MyLinkedList1<E> implements Serializable {
    private int size;
    private Node<E> frist;
    private Node<E> last;

    public MyLinkedList1(){
        System.out.println("无参数默认构造");
    }

    public boolean add(E e){
        addLast(e);
        return true;
    }

    private void addLast(E e){
        final Node<E> l=this.last;
        final Node<E> newNodw=new Node<E>(l,e,null);
        last=newNodw;
        if(l==null){
            frist=newNodw;
        }else{
            l.next=newNodw;
        }
        size++;
    }


    private static class Node<E>{
        private E item;
        private Node<E> prev;
        private Node<E> next;

        public Node(Node<E> prev,E element,Node<E> next){
            this.item=element;
            this.prev=prev;
            this.next=next;
        }
    }
}
