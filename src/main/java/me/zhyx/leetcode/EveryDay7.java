package me.zhyx.leetcode;

import java.util.Arrays;

/**
 * @auther zhyx
 * @Date 2020/5/13 8:55
 * @Description
 */
public class EveryDay7 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayRankTransform(new int[]{1231,234,12,523,645,7,869,7689,0,87,3452,235,784,8678,535,6})));
    }
    /**
     *给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。
     *
     * 序号代表了一个元素有多大。序号编号的规则如下：
     *
     * 序号从 1 开始编号。
     * 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
     * 每个数字的序号都应该尽可能地小。
     *  
     *
     * 示例 1：
     *
     * 输入：arr = [40,10,20,30]
     * 输出：[4,1,2,3]
     * 解释：40 是最大的元素。 10 是最小的元素。 20 是第二小的数字。 30 是第三小的数字。
     * 示例 2：
     *
     * 输入：arr = [100,100,100]
     * 输出：[1,1,1]
     * 解释：所有元素有相同的序号。
     * 示例 3：
     *
     * 输入：arr = [37,12,28,9,100,56,80,5,12]
     * 输出：[5,3,4,2,8,6,7,1,3]
     *  
     */
    public static int[] arrayRankTransform(int[] arr) {
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        //找出最大值和最小值
        for(int num:arr){
            if(num>max){
                max=num;
            }
            if(num<min){
                min=num;
            }
        }
        //创建一个可以包含所有元素的桶，将出现在该桶内的元素的每个位置标记为1
        int [] count=new int[max-min+1];
        for(int num:arr){
            count[num-min]=1;
        }
        //这一步是将所有出现过的数字进行一个出现次数计算，每个位置都是元素，这里包含了所有元素的顺序。
        int [] preSum=new int[count.length+1];
        for(int i=1;i<preSum.length;i++){
            preSum[i]=preSum[i-1]+count[i-1];
        }
        //通过顺序映射到ans数组中。
        int []ans =new int[arr.length];
        int index=0;
        for(int num:arr){
            ans[index++]=preSum[num-min]+1;
        }
        return ans;
    }
}
