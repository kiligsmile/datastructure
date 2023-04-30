package com.smile.datastructure.linkedlist;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class TestSinglyLinkedListSentinel {

    private SinglyLinkedListSentinel getLinkedList(){
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        return list;
    }
    @Test
    public void test(){
        SinglyLinkedListSentinel list = getLinkedList();
        list.loop2(value->{
            System.out.println(value);
        });
    }

    @Test
    public void test1(){
        SinglyLinkedListSentinel list = getLinkedList();
        for (Integer value : list) {
            System.out.println(value);
        }
    }

    @Test
    public void test2(){
        SinglyLinkedListSentinel list = getLinkedList();
        List<Integer> intList = Arrays.asList(1,2,3,4);
        assertIterableEquals(intList,list);
    }

    @Test
    @DisplayName("测试 get")
    public void test3(){
        SinglyLinkedListSentinel list = getLinkedList();
        assertEquals(3,list.get(2));

        // 验证异常情况
        assertThrows(IllegalArgumentException.class,()->list.get(10));
    }

    @Test
    @DisplayName("测试 insert")
    public void test4(){
        SinglyLinkedListSentinel list = getLinkedList();
        list.insert(0,5);
        List<Integer> intList = Arrays.asList(5,1,2,3,4);
        assertIterableEquals(intList,list);

        list = getLinkedList();
        list.addFirst(5);
        assertIterableEquals(intList,list);

        SinglyLinkedListSentinel list2=new SinglyLinkedListSentinel();
        list2.addFirst(5);
        List<Integer> intList2 = Arrays.asList(5);
        assertIterableEquals(intList2,list2);
    }
    @Test
    @DisplayName("测试 remove")
    public void test5(){
        SinglyLinkedListSentinel list = getLinkedList();
        list.remove(2);
        List<Integer> intList = Arrays.asList(1,2,4);
        assertIterableEquals(intList,list);

        SinglyLinkedListSentinel list2 = getLinkedList();
        list2.remove(0);
        List<Integer> intList2 = Arrays.asList(2,3,4);
        assertIterableEquals(intList2,list2);
    }

    @Test
    @DisplayName("测试 removeFirst")
    public void test6(){
        SinglyLinkedListSentinel list = getLinkedList();
        list.removeFirst();
        List<Integer> intList = Arrays.asList(2,3,4);
        assertIterableEquals(intList,list);
    }


}
