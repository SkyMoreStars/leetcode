package me.zhyx.leetcode;

/**
 * @auther zhyx
 * @Date 2020/7/9 8:25
 * @Description
 */
public class EveryDay37 {
    /**
     * 给定一个数字，判断其对应Excel的横坐标
     * 如1，输出A，256输出IV，701输入ZY
     */
    public String outputExcel(int i){
        if(i<=0){
            return null;
        }
        StringBuilder result=new StringBuilder();
        while (true){
            if(i>0&&i<26){
                result.append(findLetter(i));
                break;
            }
            result.append(findLetter(i%26));
            i=i/26;
        }
        return result.reverse().toString();
    }

    private String findLetter(int i) {
        if(i==0){
            i=26;
        }
        char a= (char) (64+i);
        return a+"";
    }

    public static void main(String[] args) {
        EveryDay37 everyDay37 = new EveryDay37();
        System.out.println(everyDay37.outputExcel(9595));
    }

}
