package com.smile.algorithm.recursion_single;


// 递归实现冒泡排序
public class E04BubbleSort {
    public static void sort(int [] a){
        bubble(a,a.length-1);
    }

    // 函数作用：将左侧未排序区的最大值，放置排序区域的最左侧
    // 左边界固定为0，j代表未排序区域右边界
    private static void bubble(int[] a,int j){
        if(j==0){
            return;
        }
        int x=0;
        for(int i=0;i<j;i++){
            if(a[i]>a[i+1]){
                int t=a[i];
                a[i]=a[i+1];
                a[i+1]=t;
                x=i;   // 减少不必要的递归，x为有序与无序的分界线
            }
        }
        bubble(a,x);
    }

    public static void main(String[] args) {
        int[] a={6,5,4,3,2,1};
        bubble(a,a.length);
    }
}
