package com.smile.datastructure.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TestDoubleLinkedListSentinel {

    @Test
    void addFirst() {
        DoubleLinkedListSentinel list = new DoubleLinkedListSentinel();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        List<Integer> intList = Arrays.asList(4, 3, 2, 1);
        assertIterableEquals(intList, list);
    }

    @Test
    void removeFirst() {
        DoubleLinkedListSentinel list = getList();
        list.removeFirst();
        List<Integer> intList1 = Arrays.asList(2, 3, 4);
        assertIterableEquals(intList1, list);
        list.removeFirst();
        List<Integer> intList2 = Arrays.asList(3, 4);
        assertIterableEquals(intList2, list);
        list.removeFirst();
        List<Integer> intList3 = Arrays.asList(4);
        assertIterableEquals(intList3, list);
        list.removeFirst();
        List<Integer> intList4 = Arrays.asList();
        assertIterableEquals(intList4, list);
        assertThrows(IllegalArgumentException.class, list::removeFirst);
    }

    @Test
    void addLast() {
        DoubleLinkedListSentinel list = getList();
        List<Integer> intList1 = Arrays.asList(1, 2, 3, 4);
        assertIterableEquals(intList1, list);
    }

    private DoubleLinkedListSentinel getList() {
        DoubleLinkedListSentinel list = new DoubleLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        return list;
    }

    @Test
    void removeLast() {
        DoubleLinkedListSentinel list = getList();
        list.removeLast();
        List<Integer> intList1 = Arrays.asList(1, 2, 3);
        assertIterableEquals(intList1, list);
        list.removeLast();
        List<Integer> intList2 = Arrays.asList(1, 2);
        assertIterableEquals(intList2, list);
        list.removeLast();
        List<Integer> intList3 = Arrays.asList(1);
        assertIterableEquals(intList3, list);
        list.removeLast();
        List<Integer> intList4 = Arrays.asList();
        assertIterableEquals(intList4, list);
        assertThrows(IllegalArgumentException.class, list::removeLast);
    }

    @Test
    void insert() {
        DoubleLinkedListSentinel list = getList();
        list.insert(2, 5);
        List<Integer> intList1 = Arrays.asList(1, 2, 5, 3, 4);
        assertIterableEquals(intList1, list);
        list.insert(5, 6);
        List<Integer> intList2 = Arrays.asList(1, 2, 5, 3, 4, 6);
        assertIterableEquals(intList2, list);
        assertThrows(IllegalArgumentException.class, () -> list.insert(7, 7));
    }

    @Test
    void remove() {
        DoubleLinkedListSentinel list = getList();
        list.remove(2);
        List<Integer> intList = Arrays.asList(1, 2, 4);
        assertIterableEquals(intList, list);
        assertThrows(IllegalArgumentException.class, () -> list.remove(10));

        DoubleLinkedListSentinel list2 = new DoubleLinkedListSentinel();
        assertThrows(IllegalArgumentException.class, () -> list2.remove(0));
    }
}