package me.zhyx.leetcode;

/**
 * @auther zhyx
 * @Date 2020/5/29 8:14
 * @Description
 */
public class EveryDay18 {
    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，、
     * 并返回其索引。如果目标值不存在与数组中，返回
     * 他将会被插入的位置
     */
    public int searchInsertPosition(int [] a,int target){
        if(a.length==1){
            return a[0]>target?0:1;
        }
        int position =0;
        while (position<a.length){
            if(a[position]>=target){
                return position;
            }else {
                position++;
            }
        }
        return position;
    }

    public static void main(String[] args) {
        EveryDay18 everyDay18 = new EveryDay18();
        System.out.println(everyDay18.searchInsertPosition(new int []{1,2,3,4,6},5));
    }
}
