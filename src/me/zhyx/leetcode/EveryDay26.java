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
            return false;
        }
        if(t1==null||t2==null){
            return false;
        }
        if(t1.val!=t2.val){
            return false;
        }
        return isSameTree(t1.right,t2.right)&&isSameTree(t1.left,t2.right);
    }
}
