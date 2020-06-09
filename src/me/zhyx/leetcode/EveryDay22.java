package me.zhyx.leetcode;

/**
 * @auther zhyx
 * @Date 2020/6/9 8:35
 * @Description
 */
public class EveryDay22 {

    static class Tree{
        int val;
        Tree left;
        Tree right;
    }
    /**
     * 找出二叉树的最大的高度
     */
    public int maxDepth(Tree root){
        if(root==null){
            return 0;
        }else {
            int left_height=maxDepth(root.left);
            int right_height=maxDepth(root.right);
            return Math.max(left_height,right_height)+1;
        }

    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.val=1;
        Tree left1 = new Tree();
        tree.left=left1;
        Tree left2=new Tree();
        left1.left=left2;
        Tree left3 =new Tree();
        left2=left3;
        tree.right=new Tree();
        EveryDay22 everyDay22 = new EveryDay22();
        System.out.println(everyDay22.maxDepth(tree));
    }
}
