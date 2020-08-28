package me.zhyx.base;

/**
 * @auther zhyx
 * @Date 2020/8/4 16:22
 * @Description
 */
public class ThreadSwapTest {

    public static void main(String[] args) {
        final Object a = new Object();

        new Thread(() -> {
            for (int j = 0; j < 100; j++) {
                synchronized (a) {
                    System.out.println(Thread.currentThread().getName() + "打印数字" + j);
                    try {
                        a.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        }, "A").start();
        new Thread(() -> {
            for (int j = 0; j < 100; j++) {
                synchronized (a) {
                    System.out.println(Thread.currentThread().getName() + "打印字母" + (char) (j));
                    a.notify();
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
    }


}
