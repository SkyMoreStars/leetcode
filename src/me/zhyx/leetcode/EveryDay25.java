package me.zhyx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther zhyx
 * @Date 2020/6/16 8:33
 * @Description
 */
public class EveryDay25 {
    /**
     * 按层级遍历二叉树
     */
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public List<List<Integer>> levelOrderBottom(TreeNode root){
        List<List<Integer>> result =new ArrayList<>();
        find(root,1,result);
        return result;
    }

    private void find(TreeNode root, int level, List<List<Integer>> result) {
        if(root==null){
            return;
        }
        if(level>result.size()){
            result.add(0,new ArrayList<>());
        }
        result.get(result.size()-level).add(root.val);
        find(root.left,level+1,result);
        find(root.right,level+1,result);

    }
}
