package me.zhyx.leetcode;

import java.util.Stack;

/**
 * @auther zhyx
 * @Date 2020/7/30 16:05
 * @Description
 */
public class EveryDay42 {
    private static class Node{
        private Node next;
        private int val;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "next=" + next +
                    ", val=" + val +
                    '}';
        }
    }
    /**
     * 寻找相交链表节点
     */
    public Node findNode(Node node1,Node node2){
        Stack<Node> nodeStack1 =new Stack<>();
        Stack<Node> nodeStack2=new Stack<>();
        Node tempNode1=node1;
        Node tempNode2=node2;
        while (tempNode1!=null||tempNode2!=null){
            if(tempNode1!=null){
                nodeStack1.push(tempNode1);
                tempNode1=tempNode1.next;
            }
            if(tempNode2!=null){
                nodeStack2.push(tempNode2);
                tempNode2=tempNode2.next;
            }
        }
        Node old=null;
        while (true){
            try {
                tempNode1=nodeStack1.pop();
                tempNode2=nodeStack2.pop();
                if(tempNode1==tempNode2){
                    old=tempNode1;
                }else {
                    break;
                }
            }catch (Exception e){
                return old;
            }

        }
        return old;
    }

    public Node findNode1(Node node1,Node node2){
        Node nodeHeadA= node1;
        Node nodeHeadB= node2;
        Node tailA=null,tailB=null;
        while (true){
            if(nodeHeadA.next==null){
                tailA=nodeHeadA;
                nodeHeadA=node2;
            }else {
                nodeHeadA=nodeHeadA.next;
            }
            if(nodeHeadB.next==null){
                tailB=nodeHeadB;
                nodeHeadB=node1;
            }else {
                nodeHeadB=nodeHeadB.next;
            }
            if(tailA!=null&&tailB!=null&&tailA!=tailB){
                return null;
            }
            if(nodeHeadA==nodeHeadB){
                return nodeHeadA;
            }

        }
    }
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);

        node9.next=node1;
        node1.next=node2;
        node3.next=node4;
        node4.next=node5;
        node5.next=node2;
        node2.next=node6;
        node6.next=node7;
        node7.next=node8;

        EveryDay42 everyDay42 = new EveryDay42();
        Node node = everyDay42.findNode1(node9, node3);
        System.out.println(node==null?null:node.val);
    }
}
