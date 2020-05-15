package me.zhyx.leetcode;


import java.math.BigDecimal;
import java.util.Arrays;

public class EveryDay4 {
    public static void main(String[] args) {

        long a= 12341234L;
        long b=13563456L;
        a^=b;
        b^=a;
        a^=b;
        System.out.println(a+"   "+ b);
        System.out.println(reverseVowels("leetcode"));
    }
    /**
     * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
     *
     * 示例 1:
     *
     * 输入: "hello"
     * 输出: "holle"
     * 示例 2:
     *
     * 输入: "leetcode"
     * 输出: "leotcede"
     * 说明:
     * 元音字母不包含字母"y"。
     */
    public static String reverseVowels(String s) {
        char [] str= s.toCharArray();
        int length=str.length;
        int l=0;
        int r=length-1;
        while (l<r){
            if(l<length&&!isVowel(str[l])){
                l++;
            }
            if(r<length&&!isVowel(str[r])){
                r--;
            }

            if(l>=r){
                break;
            }
            swap(str,l,r);
            l++;
            r--;
        }
        return new String(str);

    }

    private static void swap(char[] str, int l, int r) {
        char temp =str[r];
        str[r]=str[l];
        str[l]=temp;
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                ||ch=='A'|| ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
