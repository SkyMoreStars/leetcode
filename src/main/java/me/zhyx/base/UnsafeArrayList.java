package me.zhyx.base;

import java.util.ArrayList;

/**
 * @author: yx.zh
 * @date: 2020-06-20 20:03
 **/
public class UnsafeArrayList {
    public static void main(String[] args) {
        final ArrayList<String> integers = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                synchronized (integers) {
                    integers.add(Thread.currentThread().getName());
                }
            }).start();
        }

        System.out.println(integers.size());
    }
}
