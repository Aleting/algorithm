package com.interview.xiecheng;
import java.util.*;

public class 链表排序 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    public static ListNode partition(ListNode head,int m) {
        ListNode node = head;
        ListNode head2= null;
        ListNode node1 = null;
        ListNode head3= null;
        ListNode node2 = null;
        while (node!=null){
            if (node.val<=m){
                if (head2 == null){
                    node1 = new ListNode(node.val);
                    head2 = node1;
                }else {
                    node1.next=new ListNode(node.val);
                    node1=node1.next;
                }
            }else {
                if (head3 == null){
                    node2 = new ListNode(node.val);
                    head3 = node2;
                }else {
                    node2.next=new ListNode(node.val);
                    node2=node2.next;
                }
            }
            node=node.next;
        }
        node1.next = head3.next;
        return node1;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode head=null;
        ListNode node=null;
        int m=in.nextInt();
        while(in.hasNextInt()){
            int v=in.nextInt();
            if(head==null){
                node=new ListNode(v);
                head=node;
            }else{
                node.next=new ListNode(v);
                node=node.next;
            }
        }
        head= partition(head,m);
        if(head!=null){
            System.out.print(head.val);
            head=head.next;
            while(head!=null){
                System.out.print(",");
                System.out.print(head.val);
                head=head.next;
            }
        }
    }
}

