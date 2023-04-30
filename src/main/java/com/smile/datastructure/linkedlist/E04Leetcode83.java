package com.smile.datastructure.linkedlist;

public class E04Leetcode83 {

//    方法一
    public ListNode deleteDuplicates1(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode p1=head;
        ListNode p2;
        while((p2=p1.next)!=null){
            if(p1.val==p2.val){
                p1.next=p2.next;
            }else{
                p1=p1.next;
            }
        }
        return head;
    }

//    方法二：递归
//    递归函数负责返回：从当前节点开始，完成去重的链表
    public ListNode deleteDuplicates(ListNode p){
        if(p==null||p.next==null){
            return p;
        }
        if(p.val==p.next.val){
            return deleteDuplicates(p.next);
        }else {
            p.next=deleteDuplicates(p.next);
            return p;

        }
    }

    public static void main(String[] args) {
        ListNode head=ListNode.of(1,1,2,3,3,4);
        System.out.println(head);
        System.out.println(new E04Leetcode83().deleteDuplicates(head));
    }
}
