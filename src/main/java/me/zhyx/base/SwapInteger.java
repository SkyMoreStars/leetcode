package me.zhyx.base;

import java.lang.reflect.Field;

/**
 * @author: yx.zh
 * @date: 2020-06-30 22:36
 **/
public class SwapInteger {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Integer a=1;
        Integer b=2;
        System.out.println("交换之前a="+a+",b="+b);
        swap(a,b);
        System.out.println("交换之后a="+a+",b="+b);
    }

    private static void swap(Integer a, Integer b) throws NoSuchFieldException, IllegalAccessException {
        Field value = Integer.class.getDeclaredField("value");
        value.setAccessible(true);
        int num=a;
        value.setInt(a,b);
        value.setInt(b,num);
    }
}
