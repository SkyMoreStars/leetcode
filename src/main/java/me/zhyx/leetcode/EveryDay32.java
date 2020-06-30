package me.zhyx.leetcode;

/**
 * @auther zhyx
 * @Date 2020/6/30 8:19
 * @Description
 */
public class EveryDay32 {
    /**
     * 爬楼梯，给定一个n级台阶，每次可以有爬1级，或两级的方式。
     * 问有多少种爬法
     * 爬1阶：1=1种
     * 爬2阶：1，2=2种
     * 爬3阶：[1,1,1],[1,2],[2,1]=3种
     * 爬4阶：[1,1,1,1],[1,2,1],[1,1,2],[2,1,1],[2,2]=5
     * ……
     * 爬n阶：f(n-1)+f(n-2)
     */
    public int climbStairs(int n){
        //记住爬第n-1和n-2的值。p=n-2,q=n-1,r=p+q
        int p=0,q=0,r=1;
        for(int i=1;i<=n;++i){
            p=q;
            q=r;
            r=p+q;
        }
        return r;
    }

    public static void main(String[] args) {
        EveryDay32 everyDay32 = new EveryDay32();
        System.out.println(everyDay32.climbStairs(6));
    }
}
