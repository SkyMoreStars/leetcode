package me.zhyx.leetcode;

public class EveryDay1 {
    public static void main(String[] args) {
        System.out.println(customSortString("cba","abcd"));
    }
    /**
     * 字符串S和T只包含小写字符。在S中，所有字符只会出现一次。
     * S已经根据某种规则进行排序。我们要根据S中的顺序对T进行排序。
     * 更具体地说，如果S中x在y之前出现，那么返回的字符串中X也应该出现
     * 在Y之前。
     *
     * 返回任意一种复合条件的字符串T
     *
     * 示例
     * 输入：
     * S=”cba”
     * T=“abcd”
     * 输出：“cbad”
     */
    public  static String customSortString(String S,String t){
        /**
         * 用pos数组去存储所有t字符串的字符出现个数，下标为字母在26个字母中的位置。值为出现的次数
         */
        int [] pos= new int[27];
        String result="";
        for (int i = 0; i < t.length(); i++) {
            pos[t.charAt(i)-'a']++;
        }
        for (char temp : S.toCharArray()){
            while(pos[temp-'a']>0){
                result+=temp;
                pos[temp-'a']--;
            }
            pos[temp-'a']=0;
        }
        for (int i = 0; i < pos.length; i++) {
            while (pos[i]>0){
                result+=(char)(i+'a');
                pos[i]--;
            }
        }
        return result;
    }
}
