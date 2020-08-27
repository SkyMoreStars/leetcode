package me.zhyx.base.gc;

import java.util.ArrayList;

/**
 * @auther zhyx
 * @Date 2020/8/5 14:13
 * @Description
 */
public class GCTest {
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        for(;;){
            byte[] bytes=new byte[1024*1024];
            objects.add(bytes);
        }
    }
}
