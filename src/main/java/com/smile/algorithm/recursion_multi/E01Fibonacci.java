package com.smile.algorithm.recursion_multi;

import java.util.Arrays;

//每个递归函数里包含多个自身调用，称之为multi recursion
//递归求斐波那契第n项
public class E01Fibonacci {
//    递归次数
//    f(3)=>5
//    f(4)=>9
//    f(5)=>15
//    f(n)=>2*f(n+1)-1


//    使用Memorizaion（记忆法，也称备忘录）改进
    public static int fibonacci(int n){
        int[] cache=new int[n+1];
        Arrays.fill(cache,-1);  // 初始化数组，-1表示还没计算出值
        cache[0]=0;
        cache[1]=1;
        return f(n,cache);
    }

    public static int f(int n,int[] cache){
        if(cache[n]!=-1){
            return cache[n];
        }
        int x=f(n-1,cache);
        int y=f(n-2,cache);
        cache[n]=x+y;
        return cache[n];
    }
}

