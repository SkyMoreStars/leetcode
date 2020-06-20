package me.zhyx.leetcode;

/**
 * @auther zhyx
 * @Date 2020/5/15 8:58
 * @Description
 */
public class EveryDay9 {
    /**
     * 给出一个32位的有符号整数，你需要将这个整数中每位上的数字进行反转
     * 示例1：
     * 输入：123
     * 输出：321
     * 示例2：
     * 输入：-123
     * 输出：-321
     * 示例3：
     * 输入：120
     * 输出：21
     * 注意：我们的环境只能存储的下32的有符号整数，则其范围为Integer.MIN_VALUE和Integer.MAX_VALUE
     * @param num
     */
    public static int reverseInt(int num){
        int res=0;
        while (num!=0){
            int temp =num%10;
            num=num/10;
            if(res>Integer.MAX_VALUE/10||(res==Integer.MAX_VALUE&&temp>Integer.MAX_VALUE%10)){
                return 0;
            }
            if(res<Integer.MIN_VALUE/10||(res==Integer.MIN_VALUE&&temp<Integer.MIN_VALUE%10)){
                return 0;
            }
            res=res*10+temp;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(reverseInt(0));
    }
}
