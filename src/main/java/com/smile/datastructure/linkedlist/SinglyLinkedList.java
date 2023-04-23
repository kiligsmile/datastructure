package com.smile.datastructure.linkedlist;


public class SinglyLinkedList {
    private Node head=null;   // 头指针

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

    public void loop(){
        Node p=head;
        while(p!=null){
            System.out.println(p.value);
            p=p.next;
        }
    }
}
