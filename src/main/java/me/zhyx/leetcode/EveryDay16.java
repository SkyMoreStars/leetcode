package me.zhyx.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @auther zhyx
 * @Date 2020/5/27 8:25
 * @Description
 */
public class EveryDay16 {
    /**
     * 给定两个整数n和k，返回1...n中所有可能的k个数组合。
     * 输入：n=4，k=2
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4]
     * ]
     */
    List<List<Integer>> output = new LinkedList<>();
    int n;
    int k;

    public void backtrack(int first, LinkedList<Integer> curr) {
        if (curr.size() == k) {
            output.add(new LinkedList<>(curr));
        }
        for (int i = first; i < n + 1; i++) {
            curr.add(i);
            backtrack(i + 1, curr);
            curr.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<Integer>());
        return output;
    }

    public static void main(String[] args) {
        EveryDay16 everyDay16 = new EveryDay16();
        System.out.println(everyDay16.combine(40, 2).size());
    }
}
