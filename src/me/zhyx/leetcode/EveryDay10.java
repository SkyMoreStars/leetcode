package me.zhyx.leetcode;

/**
 * @auther zhyx
 * @Date 2020/5/18 8:33
 * @Description
 */
public class EveryDay10 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"abstract","alone","abs"}));
    }
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀
     * 如果不存在公共前缀，返回空字符串“”;
     */
    public static String longestCommonPrefix(String[] strs){
        if(strs.length==0){
            return "";
        }
        String prefix=strs[0];
        for(int i=1;i<prefix.length();i++){
            while (strs[i].indexOf(prefix)!=0){
                prefix=prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()){
                    return "";
                }
            }
        }
        return prefix;
    }
}
