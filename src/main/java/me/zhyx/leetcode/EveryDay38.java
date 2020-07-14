package me.zhyx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther zhyx
 * @Date 2020/7/14 8:08
 * @Description
 */
public class EveryDay38 {
    /**
     * 杨辉三角
     */
    private List<Long> generate(int rowIndex){
        List<Long> ans=new ArrayList<>();
        if(rowIndex==1){
            ans.add(1L);
            return ans;
        }
        if(rowIndex==2){
            ans.add(1L);
            ans.add(1L);
            return ans;
        }
        Long x;
        List<Long> last=generate(rowIndex-1);
        for(int i=0;i<rowIndex;i++){
            if(i==0||i==rowIndex-1){
                x=1L;
            }else{
                x=last.get(i-1)+last.get(i);
            }
            ans.add(x);
        }
        return ans;
    }

    public static void main(String[] args) {
        EveryDay38 everyDay38 = new EveryDay38();
        System.out.println(everyDay38.generate(67));

    }
}
