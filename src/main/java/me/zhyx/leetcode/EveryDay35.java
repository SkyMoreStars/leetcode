package me.zhyx.leetcode;

import me.zhyx.base.T;

/**
 * @auther zhyx
 * @Date 2020/7/6 8:38
 * @Description
 */
public class EveryDay35 {
    private static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    /**
     * 判断两棵树是否是相同的树
     */
    public boolean isSameTree(TreeNode t1, TreeNode t2){
        if(t1==null&&t2==null){
            return true;
        }
        if(t1==null||t2==null){
            return false;
        }
        if(t1.val!=t2.val){
            return false;
        }
        return isSameTree(t1.left,t2.left)&& isSameTree(t1.right,t2.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(3);
        TreeNode t7 = new TreeNode(4);
        TreeNode t8 = new TreeNode(4);
        t1.left=t3;
        t2.left=t4;
        t1.right=t5;
        t2.right=t6;
        t3.left=t7;
        t4.left=t8;

        EveryDay35 everyDay35 = new EveryDay35();
        System.out.println(everyDay35.isSameTree(t1, t2));
    }
}
