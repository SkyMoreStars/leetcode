package me.zhyx.leetcode;

import java.util.Arrays;

/**
 * @auther zhyx
 * @Date 2020/6/22 8:24
 * @Description
 */
public class EveryDay28 {
    /**
     * 买卖股票的最佳时机
     * [7,1,5,6,3,5,4]
     *
     * 最大利润为5因为6-1=5 必须符合先买后卖的原则
     *
     * 最小值一定要在最大值的左边
     */
    public int getMaxDifferencePrice(int [] price){
        if(price.length==0){
            return 0;
        }
        int max=price[0];
        int min=price[0];
        int maxDifferencePrice=-1;
        for (int i = 0; i < price.length; i++) {
            if(min>price[i]){
                max=price[i];
                min=price[i];
                maxDifferencePrice=maxDifferencePrice>max-min?maxDifferencePrice:(max-min);
            }
            if(max<price[i]){
                max=price[i];
                maxDifferencePrice=maxDifferencePrice>max-min?maxDifferencePrice:(max-min);
            }
        }
        return maxDifferencePrice;
    }

    public static void main(String[] args) {
        EveryDay28 everyDay28 = new EveryDay28();
        System.out.println(everyDay28.getMaxDifferencePrice(new int[]{6, 4, 5, 1, 3, 1, 4}));
    }
}
