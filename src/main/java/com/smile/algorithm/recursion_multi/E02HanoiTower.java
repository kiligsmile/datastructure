package com.smile.algorithm.recursion_multi;

import java.util.LinkedList;

public class E02HanoiTower {
    static LinkedList<Integer> a=new LinkedList<>();
    static LinkedList<Integer> b=new LinkedList<>();
    static LinkedList<Integer> c=new LinkedList<>();

//    初始化一根柱子，给它上面放上圆盘
    static void init(int n){
        for (int i=n;i>=1;i--){
            a.addLast(i);
        }
    }

   /**
    * @Description:  汉诺塔问题
    * @Author: kiligsmile
    * @Date: 2023/4/28 4:39 PM
    * @Param:
    * @param n 圆盘个数
    * @param a  源柱子
    * @param b  借用柱
    * @param c  目标柱子
    * @Return: void
   */

//   时间复杂度：T(n)=2T(n-1)+c, O(2^n)
    static void move(int n,LinkedList<Integer> a,LinkedList<Integer> b,LinkedList<Integer> c){
        if(n==0){
            return;
        }
        move(n-1,a,c,b);
        c.addLast(a.removeLast());
        print();
        move(n-1,b,a,c);

   }
    public static void main(String[] args) {
        init(3);
        print();
        move(3,a,b,c);
    }

    private static void print() {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
