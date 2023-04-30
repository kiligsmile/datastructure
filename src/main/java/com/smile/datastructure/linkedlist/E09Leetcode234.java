package com.smile.datastructure.linkedlist;

public class E09Leetcode234 {

//    步骤1.找中间点
//    步骤1.中间点后半个链表反转
//    步骤1.反转后链表与原链表逐一比较
    public boolean isPalindrome1(ListNode head){
        ListNode middle=middle(head);
        ListNode newHead=reverse(middle);
        while(newHead!=null){
            if(newHead.val!=head.val){
                return false;
            }
            head=head.next;
            newHead=newHead.next;
        }
        return true;
    }

    private ListNode middle(ListNode head){
        ListNode p1=head;
        ListNode p2=head;
        while(p2!=null&&p2.next!=null){
            p1=p1.next;
            p2=p2.next;
            p2=p2.next;
        }
        return p1;
    }

    // p89  根据题目要求 不考虑链表为空的情况
    private ListNode reverse(ListNode o1){
        ListNode n1=null;
        while(o1!=null){
            ListNode o2=o1.next;
            o1.next=n1;
            n1=o1;
            o1=o2;
        }
        return n1;
    }


//    方法二：
//    步骤一：找中间点的同时反转前半个链表
//    步骤二：反转后的前半个链表 与 中间点开始的后半个链表 逐一比较

    public boolean isPalindrome(ListNode head){
        ListNode p1= head;
        ListNode p2= head;
        ListNode n1=null;
        ListNode o1=head;
        while(p2!=null&&p2.next!=null){
            p1=p1.next;
            p2=p2.next;
            p2=p2.next;

            // 反转链表
//            ListNode o2=o1.next;
            o1.next=n1;
            n1=o1;
//            o1=o2;
            o1=p1;
        }

        if(p2!=null){  // 奇数节点
            p1=p1.next;
        }
        while (n1!=null){
            if(n1.val!= p1.val){
                return false;
            }
            n1=n1.next;
            p1=p1.next;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new E09Leetcode234().isPalindrome(ListNode.of(1,2,2,1)));
        System.out.println(new E09Leetcode234().isPalindrome(ListNode.of(1,2,3,2,1)));
        System.out.println(new E09Leetcode234().isPalindrome(ListNode.of(1,2,3,2,4,1)));
    }
}
