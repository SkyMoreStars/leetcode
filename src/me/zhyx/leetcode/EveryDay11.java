package me.zhyx.leetcode;

import java.util.List;

/**
 * @auther zhyx
 * @Date 2020/5/19 8:05
 * @Description
 */
public class EveryDay11 {
    static class ListNode{
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }
    }
    /**
     * 删除链表中倒数第n个节点
     * 说明：保证n值是有效的。
     */
    public ListNode removeNthFromEnd(ListNode listNode,int n){
        ListNode dunmy=new ListNode(0);
        dunmy.next=listNode;
        int length=0;
        ListNode firstPos=dunmy;
        ListNode secondPos=dunmy;
        /**
         * 先将firstPost移动n个长度
         */
        for(int i=0;i<n+1;i++){
            firstPos=firstPos.next;
        }
        /**
         * 同步移动secondPos和firstPos,直到firstPos到最后一个位置，那么second指针的下一个节点就是要删除的节点
         */
        while (firstPos!=null){
            firstPos=firstPos.next;
            secondPos=secondPos.next;
        }
        secondPos.next=secondPos.next.next;
        return dunmy.next;




    }

}
