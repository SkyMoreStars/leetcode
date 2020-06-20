package me.zhyx.leetcode;

import java.util.Arrays;

/**
 * @auther zhyx
 * @Date 2020/6/12 8:44
 * @Description
 */
public class EveryDay23 {
    /**
     * 给定一个由整数组成的非空数组锁表示的非负整数，在该数的基础上加1，
     * 最高位数字存放在数组的首位，数组中每个元素只村塾单个数字
     * 假设除了整数0之外，这个整数不会以0开头
     */
    public void addOne(int [] num){
        if(num==null){
            return;
        }
        int length=num.length;
        int lastPos=num[length-1];
        lastPos++;
        if(lastPos>=10){
            lastPos=lastPos%10;
            num[length-2]+=1;
        }
        num[length-1]=lastPos;
    }

    public static void main(String[] args) {
        EveryDay23 everyDay23 = new EveryDay23();
        int[] ints = {0};
        everyDay23.addOne(ints);
        System.out.println(Arrays.toString(ints));
    }
}
