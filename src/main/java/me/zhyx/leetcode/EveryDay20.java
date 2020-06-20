package me.zhyx.leetcode;

/**
 * @auther zhyx
 * @Date 2020/6/3 8:22
 * @Description
 */
public class EveryDay20 {
    /**
     * 外观数列
     * 1 -->1一个1=11
     *              |
     *              v
     *              2个1=21
     *                    |
     *                    V
     *                    1个2 1个1=1211
     * @return
     */
    public static String countAndSay(int n){
        StringBuilder s=new StringBuilder();
        int p1=0;
        int cur=1;
        if(n==1){
            return "1";
        }
        String str=countAndSay(n-1);
        for(cur=1;cur<str.length();cur++){
            if(str.charAt(p1)!=str.charAt(cur)){
                int count=cur-p1;
                s.append(count).append(str.charAt(p1));
                p1=cur;
            }
        }
        if(p1!=cur){
            int count=cur-p1;
            s.append(count).append(str.charAt(p1));
        }
        return s.toString();
    }
}
