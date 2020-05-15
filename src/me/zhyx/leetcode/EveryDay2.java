package me.zhyx.leetcode;


public class EveryDay2 {
    public static void main(String[] args) {
        System.out.println(reverseStr("adfsafwef",3));
    }
    /**
     * 给定一个字符串和一个整数k,你需要对从字符串开头算起的每个2k字符的前k个字符进行翻转。
     * 如果剩余少于k个字符，则将剩余的所有全部反转。
     * 如果小于2k但大于等于k个字符，则反转前k个字符，并将剩余的字符保持原样。
     */
    public static String reverseStr(String s,int k){
        char[] str= s.toCharArray();
        for(int left=0,step=2*k;left<str.length;left+=step){
            int right=Math.min(str.length-1,left+k-1);
            swap(str,left,right);
        }
        return new String(str);
    }

    private static void swap(char[] str, int left, int right) {
        while (left<right){
            str[left]^=str[right];
            str[right]^=str[left];
            str[left++]^=str[right];
        }
    }
}
