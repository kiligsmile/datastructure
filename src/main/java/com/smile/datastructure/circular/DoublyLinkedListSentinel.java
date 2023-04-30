package com.smile.datastructure.circular;

import java.util.Iterator;

public class DoublyLinkedListSentinel implements Iterable<Integer> {
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p=sentinel.next;
            @Override
            public boolean hasNext() {
                return p!=sentinel;
            }

            @Override
            public Integer next() {
                int value=p.value;
                p=p.next;
                return value;
            }
        };
    }

    private static class Node{
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
    private Node sentinel =new Node(null,-1,null);

    public DoublyLinkedListSentinel() {
        sentinel.prev=sentinel;
        sentinel.next=sentinel;
    }

//    不管是只有哨兵，还是有其他节点都适用
    public void addFirst(int value){
        Node prev=sentinel;
        Node next=sentinel.next;
        Node added=new Node(prev,value,next);
        prev.next=added;
        next.prev=added;
    }

    public void addLast(int value){
        Node next=sentinel;
        Node prev=sentinel.prev;
        Node added= new Node(prev,value,next);
        prev.next=added;
        next.prev=added;
    }

    public void removeFirst(){
        Node prev=sentinel;
        Node removed=prev.next;
        if(removed==sentinel){
            throw new IllegalArgumentException("非法删除");
        }
        Node next=removed.next;
        prev.next=next;
        next.prev=prev;
    }

    public void removeLast(){
        Node removed=sentinel.prev;
        if(removed==sentinel){
            throw new IllegalArgumentException("非法删除");
        }
        Node prev=removed.prev;
        prev.next=sentinel;
        sentinel.prev=prev;
    }

    public void removeByValue(int value){
        Node removed=findByValue(value);
        if(removed==null){
            return;
        }
        Node prev=removed.prev;
        Node next=removed.next;
        prev.next=next;
        next.prev=prev;
    }

    private Node findByValue(int value){
        Node p=sentinel.next;
        while(p!=sentinel){
            if(p.value==value){
                return p;
            }
            p=p.next;
        }
        return null;
    }
}
