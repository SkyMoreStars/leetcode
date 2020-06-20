package me.zhyx.leetcode;

import java.util.Arrays;

/**
 * @auther zhyx
 * @Date 2020/5/20 8:15
 * @Description
 */
public class EveryDay12 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,1,3,4,4,4,4,4}));
    }
    /**
     * 删除排序数组中的重复元素。不得使用额外空间。返回数组的新长度。
     * 输入：[0,1,1,2]
     * 输出：3-->原因是[0,1,2]
     */
    public static int removeDuplicates(int [] nums){
        int length=nums.length;
        int lastPointPosition=0;
        if(length==1){
            return 1;
        }
        /**
         * 使用movePoint遍历数组，遇到一样的就覆盖lastPointPosition
         * 遇到不一样的lastPointPosition++。
         * 当movePoint的位置处于length-1循环结束
         */
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[lastPointPosition]){
                lastPointPosition++;
                nums[lastPointPosition]=nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return lastPointPosition+1;

    }
}
