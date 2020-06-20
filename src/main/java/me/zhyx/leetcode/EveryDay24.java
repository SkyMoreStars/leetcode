package me.zhyx.leetcode;

/**
 * @auther zhyx
 * @Date 2020/6/15 8:38
 * @Description
 */
public class EveryDay24 {

    /**
     * 实现int sqrt(int x) 函数
     * 计算并返回x的平方根，其中x是非负整数。
     * 由于返回类型是整数，结果只保留整数的部分，小数都将被舍去
     */
    public int sqrt(int x){
        int l=0;
        int r=x;
        int ans=-1;
        while (l<=r){
            int mid =1+(r-1)/2;
            if ((long) mid * mid <= x) {
                ans=mid;
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        return ans;
    }
}
