package com.smile.algorithm.recursion_single;

public class E06Sum {
//    f(n)=f(n-1)+n
    public static long sum(long n){
        if(n==1){
            return 1;
        }
        return sum(n-1)+n;
    }

    public static void main(String[] args) {
//        当n的值过大，会出现爆栈，因为先递后归
        System.out.println(sum(100));
    }
}
