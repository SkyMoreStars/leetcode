package me.zhyx.leetcode;

/**
 * @auther zhyx
 * @Date 2020/7/17 8:27
 * @Description
 */
public class EveryDay39 {
    /**
     * 股票买卖的最佳时机，判断最大利润。
     */

    public int maxProfit(int []prices){
        int i=0;
        int valley=prices[0];
        int peak =prices[0];
        int maxprofit=0;
        while(i< prices.length-1){
            while (i<prices.length-1&&prices[i]>=prices[i+1]) {
                i++;
            }
            valley=prices[i];
            while(i<prices.length-1&&prices[i]<=prices[i+1]){
                i++;
            }
            peak=prices[i];
            maxprofit+=peak-valley;
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        EveryDay39 everyDay39 = new EveryDay39();
        System.out.println(everyDay39.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
