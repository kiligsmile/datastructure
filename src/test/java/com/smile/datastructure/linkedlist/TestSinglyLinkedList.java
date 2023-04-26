package com.smile.datastructure.linkedlist;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




public class TestSinglyLinkedList {

    @Test
    public void test(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.loop2(value->{
            System.out.println(value);
        });
    }

    @Test
    public void test1(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        for (Integer value : list) {
            System.out.println(value);
        }
    }

    @Test
    public void test2(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        List<Integer> intList = Arrays.asList(1,2,3,4);
        Assertions.assertIterableEquals(intList,list);
    }

    @Test
    @DisplayName("测试 get")
    public void test3(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        int i= list.get(10);
        System.out.println(i);
    }

    @Test
    @DisplayName("测试 insert")
    public void test4(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.insert(0,5);
        for (Integer value : list) {
            System.out.println(value);

        }
    }
    @Test
    @DisplayName("测试 removeFirst")
    public void test5(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.removeFirst();
        for (Integer value : list) {
            System.out.println(value);
        }
    }

}
