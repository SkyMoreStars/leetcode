package me.zhyx.leetcode;

/**
 * @auther zhyx
 * @Date 2020/6/18 8:13
 * @Description
 */
public class EveryDay26 {
    /**
     * 比较两颗二叉树是否为相同的树。
     * 一样的节点，一样的值视为相同树
     */
    static class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean isSameTree(TreeNode t1,TreeNode t2){
        if(t1==null&& t2==null){
            return true;
        }
        if(t1==null||t2==null){
            return false;
        }
        if(t1.val!=t2.val){
            return false;
        }
        return isSameTree(t1.right,t2.right)&&isSameTree(t1.left,t2.left);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        t1.left=t2;
        t2.right=t3;
        TreeNode t21 = new TreeNode(1);
        TreeNode t22=new TreeNode(2);
        TreeNode t23=new TreeNode(3);
        t21.left=t22;
        t22.right=t23;
        EveryDay26 everyDay26 = new EveryDay26();
        System.out.println(everyDay26.isSameTree(t1,t21));
    }
}
