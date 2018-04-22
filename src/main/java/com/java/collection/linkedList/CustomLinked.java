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
        //将尾节点 赋值给一个 临时节点
        final Node<E> l=last;
        //创建一个新的节点，尾节点的临时变量作为新节点的前一个节点，插入元素作为新节点的数据元素，null作为新节点的为节点
        final Node<E> newNode=new Node<E>(l,e,null);
        //将新创建的节点赋值给last节点
        last=newNode;
        //如果临时节点为null，将新创的节点赋值给首节点，否则 将临时节点的下个节点指向新创建的节点
        if(l==null){
            first=newNode;
        }else{
            l.next=newNode;
        }
        //集合大小++
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
        //创建一个节点，要指定前一个节点，节点元素，和下一个节点
        Node(Node<E> prev,E element,Node<E> next){
            this.item=element;
            this.next=next;
            this.prev=prev;
        }
    }
}
