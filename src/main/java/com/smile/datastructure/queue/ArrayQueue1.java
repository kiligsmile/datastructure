package com.smile.datastructure.queue;

import java.util.Iterator;

//普通数组移除元素效率低
//环形数组-长度固定，灵活，任意一个索引位置都可以作为头和尾

/**
 * 仅用 head, tail 判断空满, head, tail 即为索引值, tail 停下来的位置不存储元素
 *
 * @param <E> 队列中元素类型
 */
public class ArrayQueue1<E> implements Queue<E>, Iterable<E> {

    private final E[] array;
    private int head = 0;
    private int tail = 0;

    @SuppressWarnings("all")
    public ArrayQueue1(int capacity) {
        array = (E[]) new Object[capacity + 1];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[tail] = value;
        tail = (tail + 1) % array.length;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = array[head];
        array[head] = null; // help GC
        head = (head + 1) % array.length;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[head];
    }

//    头尾指针指向同一个位置
    @Override
    public boolean isEmpty() {
        return head == tail;
    }

//    尾指针+1 模数组长度为零，则满了
//    （tail+1)%5==head
    @Override
    public boolean isFull() {
        return (tail + 1) % array.length == head;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E value = array[p];
                p = (p + 1) % array.length;
                return value;
            }
        };
    }
}

