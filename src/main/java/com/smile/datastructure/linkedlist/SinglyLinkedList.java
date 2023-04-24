package com.smile.datastructure.linkedlist;


import java.util.Iterator;
import java.util.function.Consumer;

//单向链表
public class SinglyLinkedList implements Iterable<Integer> {
    private Node head=null;   // 头指针

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p=head;
            @Override
            public boolean hasNext() {    // 是否有下一个元素
                return p!=null;
            }

            @Override
            public Integer next() {   // 返回当前值，并指向下一个元素
                int v = p.value;
                p=p.next;
                return v;
            }
        };
    }

    //    节点类
    private static class Node{
        int value;   // 值
        Node next;  // 下一个节点指针
        public Node(int value,Node next){
            this.value=value;
            this.next=next;
        }
    }
    public void addFirst(int value){
//        1、链表为空
//        head=new Node(value,null);
//        2、链表非空
        head= new Node(value,head);
    }

    public void loop1(Consumer<Integer> consumer){
        Node p=head;
        while(p!=null){
            consumer.accept(p.value);
            p=p.next;
        }
    }

    public void loop2(Consumer<Integer> consumer){
        for (Node p=head;p!=null;p=p.next){
            consumer.accept(p.value);
        }
    }

    private Node findLast(){
        if(head==null){  // 空链表
            return null;
        }
        Node p;
        for (p=head;p.next!=null;p=p.next){

        }
        return p;
    }

    public void addLast(int value){
        Node last = findLast();
        if(last==null){
            addFirst(value);
            return;
        }
        last.next=new Node(value,null);
    }

}
