package com.smile.datastructure.linkedlist;


//import com.sun.jmx.snmp.SnmpNull;

import java.util.Iterator;
import java.util.function.Consumer;

//单向链表  带哨兵
public class SinglyLinkedListSentinel implements Iterable<Integer> {
    private Node head=new Node(111, null);   // 头指针

//    迭代器遍历
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p=head.next;
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
        insert(0,value);
    }

    public void loop1(Consumer<Integer> consumer){
        Node p=head.next;
        while(p!=null){
            consumer.accept(p.value);
            p=p.next;
        }
    }

    public void loop2(Consumer<Integer> consumer){
        for (Node p=head.next;p!=null;p=p.next){
            consumer.accept(p.value);
        }
    }

    private Node findLast(){
        Node p;
        for (p=head;p.next!=null;p=p.next){

        }
        return p;
    }

    public void addLast(int value){
        Node last = findLast();
        last.next=new Node(value,null);
    }

//    public void test(){
//        int i=0;
////        for循环的第一个条件，只能添加一个条件。或者定义多个变量，同一类型
//        for(Node p=head;p!=null;p=p.next,i++){
//            System.out.println(p.value+ " 索引是："+i);
//        }
//    }

//    根据给定的索引位置，返回节点对象，不暴露给外界
    private Node findNode(int index){
        int i=-1;
        for(Node p=head;p!=null;p=p.next,i++){
            if(i==index){
                return p;
            }
        }
        return null;    // 没有找到
    }

//    返回节点值
    public int get(int index){
        Node node = findNode(index);
        if(node==null){
//            抛非法参数异常
            throw illegalIndex(index);
        }
        return node.value;
    }

    private IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(
                String.format("index[%d] 不合法%n", index));
    }

    //    给链表的任意一个索引位置加入一个元素
    public void insert(int index,int value){
        Node prev=findNode(index-1);  // 找到上一个节点
        if(prev==null){
            // 索引位置非法
            throw illegalIndex(index);
        }
        prev.next= new Node(value,prev.next);
    }

//    删除第一个节点
    public void removeFirst(){
        remove(0);
    }

//    按索引删除节点
    public void remove(int index){
        Node prev=findNode(index-1);
//        prev.next=prev.next.next;
        if(prev==null){
            throw illegalIndex(index);
        }
        Node removed=prev.next;
        if(removed==null){
            throw illegalIndex(index);
        }
        prev.next=removed.next;
    }
}
