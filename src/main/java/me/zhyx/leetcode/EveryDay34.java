package me.zhyx.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @auther zhyx
 * @Date 2020/7/2 8:20
 * @Description
 */
public class EveryDay34 {
    private static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    /**
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     *
     */
    public List<String> binaryTreePaths(TreeNode root){
        LinkedList<String> paths=new LinkedList<>();
        constructPaths(root,"",paths);
        return paths;
    }

    private void constructPaths(TreeNode root, String s, LinkedList<String> paths) {
        if(root!=null){
            s+=Integer.toString(root.val);
            if(root.left==null&&root.right ==null){
                //当前是叶子节点
                paths.add(s);
            }else {
                s+="->";
                constructPaths(root.left,s,paths);
                constructPaths(root.right,s,paths);
            }
        }
    }

    public static void main(String[] args) {
        EveryDay34 everyDay34 = new EveryDay34();
        TreeNode root = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(6);
        root.left=treeNode1;
        root.right=treeNode2;
        treeNode1.left=treeNode3;
        treeNode2.right=treeNode4;
        treeNode4.left=treeNode5;
        System.out.println(Arrays.toString(everyDay34.binaryTreePaths(root).toArray()));
    }
}
