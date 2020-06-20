package me.zhyx.leetcode;


public class EveryDay5 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2= new ListNode(4);
        listNode1.next=listNode2;
        ListNode listNode3=new ListNode(3);
        listNode2.next=listNode3;
        ListNode l2=new ListNode(5);
        ListNode l2Node2= new ListNode(6);
        l2.next=l2Node2;
        ListNode l2Node3= new ListNode(4);
        l2Node3.i=4;
        l2Node2.next=l2Node3;
        ListNode result =towNumSum(listNode1,l2);
        do{
            System.out.print(result.i+"->");
            result=result.next;
        }while (result!=null);
    }
    /**
     * 给定两个非空的链表用来表示两个非负的整数。
     * 其中，他们各自的位数是按照逆序的方式进行存储的，
     * 并且他们的每个节点自能存一位数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示他们的和。
     * 您可以假设除了数字0之外，这两个数字都不会以0开头。
     * 输入：(2->4->3)+(5->6->4)
     * 输出：(7->0->8)
     * 342+465=807
     */
    public static ListNode towNumSum(ListNode l1,ListNode l2){
        ListNode result=new ListNode(0);
        ListNode curr =result;
        ListNode p= l1;
        ListNode q=l2;
        int carry=0;
        while (q!=null||q!=null){
            int valQ=q!=null?q.i:0;
            int valP=p!=null?p.i:0;
            int sum =carry+valP+valQ;
            carry=sum/10;
            curr.next=new ListNode(sum%10);
            curr=curr.next;
            if(q!=null){
                q=q.next;
            }
            if(p!=null){
                p=p.next;
            }
        }
        if(carry>0){
            curr.next=new ListNode(carry);
        }
        return result.next;
    }
    static class ListNode{
        int i;
        ListNode next;

        public ListNode(int i) {
            this.i = i;
        }
    }
}
