package me.zhyx.leetcode;

import java.util.Arrays;

/**
 * @auther zhyx
 * @Date 2020/6/23 8:59
 * @Description
 */
public class EveryDay29 {
    /**
     * 找出和最大的子串
     * [-1,3,2,4,-5,-3]
     * [3,2,4]=9
     * 贪心算法
     */
    public int maxSubString(int [] nums){
        if(nums.length==1){
            return nums[0];
        }
        int currSum=nums[0];
        int maxSum=nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum=Math.max(nums[i],nums[i]+currSum);
            maxSum=Math.max(currSum,maxSum);
        }
        return maxSum;
    }

    /**
     * 动态规划
     *
     */
    public int maxSubStrVal(int []nums){
        if(nums.length==1){
            return nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1]>0){
                nums[i]+=nums[i-1];
            }
        }
        return Arrays.stream(nums).max().getAsInt();
    }
    public static void main(String[] args) {
        EveryDay29 everyDay29 = new EveryDay29();
        System.out.printf("最终结果为%d", everyDay29.maxSubStrVal(new int[]{3,-1,4,-2,-5,6,7,-3}));
    }
}
