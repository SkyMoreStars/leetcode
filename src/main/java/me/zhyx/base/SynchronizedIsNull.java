package me.zhyx.base;

/**
 * @author: yx.zh
 * @date: 2020-08-27 09:52
 * 会爆空指针
 **/
public class SynchronizedIsNull implements Runnable {
    private Integer count = 0;
    private Object nullObj = null;

    public void Test() {
        synchronized (nullObj) {
            count++;
            System.out.println(count);
        }
    }

    @Override
    public void run() {
        Test();
    }

    private static class Test {
        public static void main(String[] args) {
            SynchronizedIsNull synchronizedIsNull = new SynchronizedIsNull();
            for (int i = 0; i < 40; i++) {
                Thread thread = new Thread(synchronizedIsNull);
                thread.start();
            }
        }
    }
}