package me.zhyx.leetcode;

/**
 * @auther zhyx
 * @Date 2020/5/25 7:58
 * @Description
 */
public class EveryDay14 {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
    /**
     * 给你n个非负整数a1,a2,...an,每个数代表坐标中的一个点(i,ai).
     * 在坐标内画n调垂直线，垂直线i的两个端点分别是（i,ai）和（i,0）。
     * 找出其中的两条线，使得他们与x轴构成的容器可以容纳最多的水。
     * 输入:[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * n至少为2
     */
    public static int maxArea(int [] height){
        if(height.length==2){
            return height[0]>height[1]?height[0]:height[1];
        }
        int lPos=0;
        int rPos=height.length-1;
        int maxArea=-1;
        while (rPos>lPos){
            int i = rPos - lPos;
            if(height[rPos]>height[lPos]){
                maxArea=maxArea<height[lPos]*i?height[lPos]*i:maxArea;
                lPos++;
            }else if(height[rPos]<=height[lPos]){
                maxArea=maxArea<height[rPos]*i?height[rPos]*i:maxArea;
                rPos--;
            }
        }
        return maxArea;
    }

}
