package com.smile.datastructure.stack;

import java.util.LinkedList;

/**
 * 后缀表达式求值
 */
public class E02Leetcode150 {

    /*

        |   |
        | 13|
        | 4 |
        _____

        "4","13","5","/","+"

        - 遇到数字压入栈
        - 遇到运算符, 就从栈弹出两个数字做运算, 将结果压入栈
        - 遍历结束, 栈中剩下的数字就是结果
     */

    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (String t : tokens) {
            Integer a,b;
            switch (t) {
                case "+":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a + b);
                    break;

                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a * b);
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                    break;
                default:
                    stack.push(Integer.parseInt(t));
                    break;
            }
        }
        return stack.pop();
    }
}
