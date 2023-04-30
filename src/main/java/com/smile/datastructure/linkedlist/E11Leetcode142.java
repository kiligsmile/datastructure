package com.smile.datastructure.linkedlist;

public class E11Leetcode142 {

//    当环为首尾相接的情况下，代码有误
    public ListNode detectCycle1(ListNode head) {
        ListNode h=head;  // 兔
        ListNode t=head;   // 龟
        while(h!=null&&h.next!=null){
            t=t.next;
            h=h.next.next;
            if(h==t){
//                进入第二阶段
                t=head;
                while(true){
                    t=t.next;
                    h=h.next;
                    if(t==h){
                        return t;
                    }
                }
            }
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode h = head;  // 兔
        ListNode t = head;   // 龟
        while (h != null && h.next != null) {
            t = t.next;
            h = h.next.next;
            if (h == t) {
//                进入第二阶段
                t = head;
                while (true) {
                    if (t == h) {
                        return t;
                    }
                    t = t.next;
                    h = h.next;
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        // 构造一个带环链表
        ListNode n12 = new ListNode(12, null);
        ListNode n11 = new ListNode(11, n12);
        ListNode n10 = new ListNode(10, n11);
        ListNode n9 = new ListNode(9, n10);
        ListNode n8 = new ListNode(8, n9);
        ListNode n7 = new ListNode(7, n8);
        ListNode n6 = new ListNode(6, n7);
        ListNode n5 = new ListNode(5, n6);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        n12.next = n8;

        System.out.println(new E11Leetcode142().detectCycle(n1).val);
    }
}
