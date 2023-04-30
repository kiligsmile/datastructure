package com.smile.algorithm.recursion_single;


public class E05InsertionSort {
    public static void sort(int[] a){
        insertion(a,1);
    }

    private static void insertion(int[] a,int low){
        // low：未排序的左边界
        if(low==a.length){
            return;
        }
        int t=a[low];
        int i=low-1;   // 已排序区域指针(右边界）
        while(i>=0&& a[i]>t){   // 没有找到插入位置
            a[i+1]=a[i];    // 空出插入位置
            i--;
        }
        if(i+1!=low){  // 减少了一次多余的复制过程，此时(i+1)=low
            a[i+1]=t;
        }
        a[i+1]=t;  // 找到插入位置
        insertion(a,low+1);
    }
}
