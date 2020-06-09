package me.zhyx.leetcode;

/**
 * @auther zhyx
 * @Date 2020/6/8 8:18
 * @Description
 */
public class EveryDay21 {
    /**
     * 实现indexOf方法。
     * 输入handelStr="hello", needle="ll"
     * 返回：2
     */
    public int indexOf(String handelStr,String needle){
        if(needle.length()==0){
            return 0;
        }
        if(handelStr.length()==0){
            return -1;
        }
        int handelStrLength= handelStr.length();
        int needleLength=needle.length();
        /**
         * 从i的位置开始，走needleLength个长度。必须保证不溢出。
         */
        for(int i=0;i<handelStrLength-needleLength+1;i++){
            String handelStrTemp="";
            int j=0;
            while (j<needleLength){
                handelStrTemp+=handelStr.charAt(j+i);
                j++;
            }
            if(handelStrTemp.equals(needle)){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        EveryDay21 everyDay21 = new EveryDay21();
        System.out.println(everyDay21.indexOf("adfasdfasdfwrqwerqwer","wrq"));
    }
}
