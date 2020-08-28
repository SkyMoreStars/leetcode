package me.zhyx.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @auther zhyx
 * @Date 2020/7/14 11:25
 * @Description
 */
public class HashMapTestDemo {

    public static void main(String[] args) {
        String s2 = new String("1234");
        s2 = s2.intern();
        String s1 = "1234";

        System.out.println(s1 == s2);
    }
}
