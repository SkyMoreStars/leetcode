package me.zhyx.base;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author: yx.zh
 * @date: 2020-06-20 20:22
 **/
public class TestJUC {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> strings = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 100000; i++) {
            new Thread(()->{
                strings.add(Thread.currentThread().getName());
            }).start();
        }
        System.out.println(strings.size());
    }
}
