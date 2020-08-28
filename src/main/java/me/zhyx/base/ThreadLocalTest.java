package me.zhyx.base;

import java.util.concurrent.TimeUnit;

/**
 * @author: yx.zh
 * @date: 2020-06-27 22:16
 **/
public class ThreadLocalTest {
    private static ThreadLocal<Persion> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
        }).start();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadLocal.set(new Persion());
        }).start();
        threadLocal.remove();
    }

    private static class Persion {
        private String name = "zhangsan";
    }
}
