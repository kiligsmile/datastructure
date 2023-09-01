package com.smile.algorithm.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.smile.algorithm.recursion_single.E04BubbleSort.sort;
import static com.smile.algorithm.sort.sort.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestSort {
    int a[]={4,3,2,1,5};
    @Test
    @DisplayName("测试直接插入排序")
    public void test1() {
        int[] expected = {1, 2, 3, 4, 5};
        insertionSort(a);
        assertArrayEquals(expected, a);
    }

    @Test
    @DisplayName("测试二分插入排序")
    public void test7() {
        int[] expected = {1, 2, 3, 4, 5};
        binaryInsertionSort(a);
        assertArrayEquals(expected, a);
    }

    @Test
    @DisplayName("测试希尔排序")
    public void test2() {
        int[] expected = {1, 2, 3, 4, 5};
        shellSort(a);
        assertArrayEquals(expected, a);
    }

    @Test
    @DisplayName("测试直接选择排序")
    public void test3() {
        int[] expected = {1, 2, 3, 4, 5};
        selectSort(a);
        assertArrayEquals(expected, a);
    }

    @Test
    @DisplayName("测试冒泡排序")
    public void test4() {
        int[] expected = {1, 2, 3, 4, 5};
        bubbleSort(a);
        assertArrayEquals(expected, a);
    }

    @Test
    @DisplayName("测试改良冒泡排序")
    public void test5() {
        int[] expected = {1, 2, 3, 4, 5};
        betterBubbleSort(a);
        assertArrayEquals(expected, a);
    }

    @Test
    @DisplayName("测试快速排序")
    public void test6() {
        int[] expected = {1, 2, 3, 4, 5};
        quickSort(a,0,a.length-1);
        assertArrayEquals(expected, a);
    }

}
