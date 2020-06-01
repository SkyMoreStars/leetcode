package me.zhyx.leetcode;


/**
 * @auther zhyx
 * @Date 2020/6/1 8:19
 * @Description
 */
public class EveryDay19 {
    static class NodeList{

        int i;
        NodeList next;

        public NodeList(int i) {
            this.i = i;
        }
    }

    /**
     * 合并两个有序的链表
     * @param n1
     * @param n2
     * @return
     */
    public NodeList mergeTowLinked(NodeList n1, NodeList n2){
        if(n1==null){
            return n2;
        }else if(n2==null){
            return n1;
        }else if(n1.i<n2.i){
             n1.next=mergeTowLinked(n1.next,n2);
             return n1;
        }else {
             n2.next=mergeTowLinked(n1,n2.next);
             return n2;
        }
    }

    public static void main(String[] args) {
        EveryDay19 everyDay19 = new EveryDay19();
        NodeList nodeList1 = new NodeList(1);
        NodeList nodeList2 = new NodeList(3);
        nodeList1.next=nodeList2;
        NodeList nodeList3 = new NodeList(5);
        nodeList2.next=nodeList3;
        NodeList nodeList4 = new NodeList(7);
        nodeList3.next=nodeList4;
        everyDay19.mergeTowLinked(nodeList1,nodeList1);
        while (nodeList1!=null){
            System.out.println(nodeList1.i+",");
            nodeList1=nodeList1.next;
        }
    }
}
