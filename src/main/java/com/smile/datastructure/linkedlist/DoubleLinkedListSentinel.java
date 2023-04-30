package com.smile.datastructure.linkedlist;

import java.util.Iterator;

//双向链表（带哨兵）
public class DoubleLinkedListSentinel implements Iterable<Integer>{
    static class Node{
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node head;  // 头哨兵
    private Node tail;   // 尾哨兵

    public DoubleLinkedListSentinel(){
        head=new Node(null,666,null);
        tail=new Node(null,888,null);
        head.next=tail;
        tail.prev=head;
    }

//    根据索引位置找到节点
    private Node findNode(int index){
        int i=-1;
        for(Node p=head;p!=tail;p=p.next,i++){
            if(i==index){
                return p;
            }
        }
        return null;
    }

    public void addFirst(int value){
        insert(0,value);
    }

    public void removeFirst(){
        remove(0);
    }

//    带哨兵的双向链表的优势在于向尾部删除节点和添加节点
    public void addLast(int value){
        Node last= tail.prev;
        Node added= new Node(last,value,tail);
        last.next=added;
        tail.prev=added;
    }

    public void removeLast(){
        Node removed=tail.prev;
//        删除头哨兵
        if(removed==head){
            throw illegalIndex(0);
        }
        Node prev=removed.prev;
        prev.next=tail;
        tail.prev=prev;
    }

    public void insert(int index,int value){
       Node prev= findNode(index-1);
       if(prev==null){
           throw illegalIndex(index);
       }
       Node next= prev.next;
       Node inserted= new Node(prev,value,next);
       prev.next=inserted;
       next.prev=inserted;
    }

    public void remove(int index){
//        被删节点索引非法
        Node prev=findNode(index-1);
        if(prev==null){
            throw illegalIndex(index);
        }
        // 被删节点为哨兵
        Node removed=prev.next;
        if(removed==tail){
            throw illegalIndex(index);
        }
        Node next=removed.next;
        prev.next=next;
        next.prev=removed;
    }

    private IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(
                String.format("index[%d] 不合法%n", index));
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
//            遍历的起始位置为头哨兵的next
            Node p=head.next;
            @Override
            public boolean hasNext() {
                return p!=tail;
            }

            @Override
            public Integer next() {
                int value=p.value;
                p=p.next;
                return value;
            }
        };
    }
}
