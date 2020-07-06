package me.zhyx.leetcode;

/**
 * @auther zhyx
 * @Date 2020/6/24 8:16
 * @Description
 */
public class EveryDay30 {
    /**
     * 求一棵二叉树是否为平衡二叉树。
     */
    private static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean isBalanced(TreeNode root){
        if(root==null){
            return true;
        }
        return Math.abs(height(root.left)-height(root.right))<2 && isBalanced(root.left)&&isBalanced(root.right);
    }

    public int height(TreeNode root){
        if(root==null){
            return -1;
        }
        return 1+Math.max(height(root.left),height(root.right));
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(6);
        treeNode.left=treeNode1;
        treeNode.right=treeNode2;
        treeNode1.left=treeNode3;
        treeNode2.right=treeNode4;
//        treeNode3.left=treeNode5;
        EveryDay30 everyDay30 = new EveryDay30();
        System.out.printf("result is ：%b", everyDay30.isBalanced(treeNode));
    }

}
