package me.zhyx.leetcode;

import java.util.*;

/**
 * @auther zhyx
 * @Date 2020/5/26 8:21
 * @Description
 */
public class EveryDay15 {
    /**
     * 给你一个包含n个整数的数组nums，判断nums中是
     * 否存在三个元素a,b,c,使得a+b+c=0?请你找出所有
     * 满足条件且不重复的三元组
     */
    public static List<List<Integer>> threeSum(int [] nums){
        if(nums==null||nums.length<=2){
            Collections.emptyList();
        }
        Arrays.sort(nums);
        Set<List<Integer>> result=new LinkedHashSet<>();
        for(int i=0;i<nums.length-2;i++){
            int target=-nums[i];
            HashMap<Integer, Integer> hash = new HashMap<>(nums.length - i);
            for(int j=i+1;j<nums.length;j++){
                int v =target-nums[j];
                Integer exist=hash.get(v);
                if(exist!=null){

                    List<Integer> list = Arrays.asList(nums[i], nums[j]);
                    list.sort(Comparator.naturalOrder());
                    result.add(list);
                }else {
                    hash.put(nums[j],nums[j]);
                }
            }
        }
        return new ArrayList<>(result);
    }
}
