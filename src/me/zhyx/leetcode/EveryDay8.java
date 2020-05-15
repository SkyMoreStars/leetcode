package me.zhyx.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @auther zhyx
 * @Date 2020/5/14 8:29
 * @Description
 */
public class EveryDay8 {
    static class TreeNode{
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    /**
     * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
     *
     * 假定 BST 有如下定义：
     *
     * 结点左子树中所含结点的值小于等于当前结点的值
     * 结点右子树中所含结点的值大于等于当前结点的值
     * 左子树和右子树都是二叉搜索树
     * 例如：
     * 给定 BST [1,null,2,2],
     *
     *    1
     *     \
     *      2
     *     /
     *    2
     * 返回[2].
     *
     * 提示：如果众数超过1个，不需考虑输出顺序
     *
     * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
     */
    int max=0,count=0;
    List<Integer> ans=new ArrayList<>();
    TreeNode pre=null;
    public int[] findNode(TreeNode root){
        if(root==null){
            return new int[0];
        }
        tree(root);
        if(count>max){
            ans.clear();//原来保存的清空
            ans.add(pre.val);
        }
        if(count==max){
            ans.add(pre.val);
        }
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }
    public void tree(TreeNode root) {
        if(root!=null){
            tree(root.left);
            //二叉树的递归遍历类似于数组的for each循环，你必须使用一个变量记录之前的遍历结果，而不能像for i 那样可以通过下标找到当前元素的前面是谁
            if(pre==null||root.val==pre.val){
                //同之前的数相等或者是第一个，计数器加一
                pre=root;
                count++;
            }else {//不相等时，
                //分三种情况讨论
                if(count>max){
                    ans.clear();//原来保存的清空
                    ans.add(pre.val);
                    max=count;
                }else if(count==max){
                    ans.add(pre.val);
                }
                pre=root;
                //计数器置1，注意是1而不是0
                count=1;
            }
            tree(root.right);
        }
    }

    public static void main(String[] args) {
    }
}
