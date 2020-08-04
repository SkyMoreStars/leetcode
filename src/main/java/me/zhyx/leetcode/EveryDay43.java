package me.zhyx.leetcode;

import java.util.ArrayList;

/**
 * @auther zhyx
 * @Date 2020/7/31 10:01
 * @Description
 */
public class EveryDay43 {
    private static class LinkedList{
        LinkedList next;
        int val;

        public LinkedList(int i) {
            this.val=i;
        }
    }
    /**
     * 给定一个单链表以k个节点为一组进行翻转
     */
    public LinkedList reverseLinkedListBuyGroup(LinkedList linkedList,int k){
        LinkedList head =linkedList;

        LinkedList headTemp=head;

        //先计算能分几个组
        int totalNodeNum=0;
        while (headTemp!=null){
            totalNodeNum++;
            headTemp=headTemp.next;

        }

        //总共分几组
        int groupCount=totalNodeNum/k;
        //前面几个
        int headNum=totalNodeNum%k;

        //修正头部----》这个元素的next就是一个组的开始
        LinkedList headGroup=head;
        if(headNum!=0){
            for (int i=0;i<headNum-1;i++){
                headGroup=headGroup.next;
            }
        }
        for (int i=0;i<groupCount;i++){
            LinkedList tempHead=headGroup.next;
            LinkedList tempTail;
            for(int j=0;j<k;j++){
                tempTail=tempHead.next;
                tempHead=tempTail;
            }


        }

        return head;
    }

    public static void main(String[] args) {
        LinkedList node1 = new LinkedList(1);
        LinkedList node2 = new LinkedList(2);
        LinkedList node3 = new LinkedList(3);
        LinkedList node4 = new LinkedList(4);
        LinkedList node5 = new LinkedList(5);
        LinkedList node6 = new LinkedList(6);
        LinkedList node7 = new LinkedList(7);
        LinkedList node8 = new LinkedList(8);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        node7.next=node8;
        EveryDay43 everyDay43 = new EveryDay43();

        LinkedList linkedList = everyDay43.reverseLinkedListBuyGroup(node1, 3);
        while (linkedList!=null){
            System.out.println(linkedList.val);
            linkedList=linkedList.next;
        }
    }
}
