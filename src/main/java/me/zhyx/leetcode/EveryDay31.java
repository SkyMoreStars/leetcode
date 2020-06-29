package me.zhyx.leetcode;

import java.util.Arrays;

/**
 * @auther zhyx
 * @Date 2020/6/29 8:16
 * @Description
 */
public class EveryDay31 {
    /**
     * 在原地删除数组中指定某个值，返回新的长度
     * nums=[7,1,2,2,3,5,8]  target=2
     */
    public int removeElement(int nums[],int target){
        if(nums==null){
            return -1;
        }
        int i=0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j]!=target){
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        EveryDay31 everyDay31 = new EveryDay31();
        int[] ints = {7, 1, 2, 2, 3, 5, 8};
        int i = everyDay31.removeElement(ints, 2);
        Arrays.stream(ints).limit(i).forEach(val->{
            System.out.print(val+",");
        });

    }
}
