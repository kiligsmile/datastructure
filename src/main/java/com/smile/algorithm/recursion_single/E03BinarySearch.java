package com.smile.algorithm.recursion_single;


// 只包含一个自身的调用，称之为single recursion
public class E03BinarySearch {

    public static int search(int[] a,int target){
        return f(a,target,0,a.length-1);
    }

    private static int f(int[]a,int target,int i,int j){
//        没找到
        if(i>j){
            return -1;
        }
        int m=(i+j)>>>1;
        if(target < a[m]){
            return f(a,target,i,m-1);
        }else if(a[m]<target){
            return f(a,target,m+1,j);
        }else {
            return m;
        }
    }
}
