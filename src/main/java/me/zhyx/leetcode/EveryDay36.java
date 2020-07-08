package me.zhyx.leetcode;

/**
 * @auther zhyx
 * @Date 2020/7/8 8:15
 * @Description
 */
public class EveryDay36 {
    private static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    /**
     * 二叉树的最小深度
     */
    public int minDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        int minDepth=Integer.MAX_VALUE;
        if(root.left!=null){
            minDepth=Math.min(minDepth(root.left),minDepth);
        }
        if(root.right!=null){
            minDepth=Math.min(minDepth(root.right),minDepth);
        }
        return minDepth+1;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2= new TreeNode(1);
        TreeNode treeNode3= new TreeNode(1);
        TreeNode treeNode4= new TreeNode(1);
        TreeNode treeNode5= new TreeNode(1);
        TreeNode treeNode6= new TreeNode(1);
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode5;
        treeNode5.right=treeNode6;
        treeNode2.left=treeNode3;
        treeNode2.right=treeNode4;
        EveryDay36 everyDay36 = new EveryDay36();
        System.out.println(everyDay36.minDepth(treeNode1));
    }
}
