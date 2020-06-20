package me.zhyx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther zhyx
 * @Date 2020/5/12 9:03
 * @Description
 */
public class EveryDay6 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }
    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右到左）读都是一样的。
     * 不用字符串来解决这个问题。
     */
    public static boolean isPalindrome(int x){
        if(x<0){
            return false;
        }
        List<Integer> list=new ArrayList();
        while (true){
            int mod =x%10;
            x=x/10;
            list.add(mod);
            if(x==0){
                break;
            }
        }
        for(int i=0;i<list.size();i++){
            if(i<=(list.size()-i-1)){
                if(!list.get(i).equals(list.get(list.size() - i-1))){
                    return false;
                }
            }
        }
        return true;
    }


}
