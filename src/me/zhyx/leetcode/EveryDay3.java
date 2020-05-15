package me.zhyx.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class EveryDay3 {
    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 20)));
    }
    /**
     * 给定一个整数数组nums和一个目标值target，请你在
     * 该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案，但是，数组中间同一个元素不能使用两边。
     *
     * @param nums 给定nums=[2,7,11,15]
     * @param target 9
     * @return [0,1]
     */
    public static int[] twoSum(int []nums,int target) throws Exception {
        HashMap<Integer,Integer> hashMapNum=new HashMap<>();
        for(int i=0;i< nums.length;i++){
            if(hashMapNum.containsKey(target-nums[i])){
                return new int[]{hashMapNum.get(target-nums[i]),i};
            }
            hashMapNum.put(nums[i],i);
        }
        throw new Exception("没有找到对应的数值");
    }
}
