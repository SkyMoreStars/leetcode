package me.zhyx.leetcode;

/**
 * @auther zhyx
 * @Date 2020/6/19 8:25
 * @Description
 */
public class EveryDay27 {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    /**
     * 判断两棵树是否是对称树
     */
    public boolean isSymmetryTree(TreeNode root){
        return check(root,root);
    }

    private boolean check(TreeNode t1, TreeNode t2) {
        if(t1==null&&t2==null){
            return true;
        }
        if(t1==null||t2==null){
            return false;
        }
        return t1.val==t2.val&& check(t1.left,t2.right)&&check(t1.right,t2.left);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        t1.right=t2;
        t1.left=t3;
        EveryDay27 everyDay27 = new EveryDay27();
        System.out.println(everyDay27.isSymmetryTree(t1));
    }
}
