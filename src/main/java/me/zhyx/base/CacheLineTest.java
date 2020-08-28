package me.zhyx.base;

/**
 * @author: yx.zh
 * @date: 2020-06-27 09:02
 * 一个缓存行是64个字节，
 **/
public class CacheLineTest {
    private static class Padding {
        /**
         * 一个long占8个字节，填充七个，占用56个字节，当有第8个long和第9个时
         * 保证这两个不会在同一个缓存行。这样就可以根据执行时间验证缓存行确实时64个字节，
         */
        public volatile long p1, p2, p3, p4, p5, p6, p7;
    }

    private static class T extends Padding {
        public volatile long x = 0;
    }

    /**
     * 模拟缓存行。
     */
    public static T a[] = new T[2];

    static {
        a[0] = new T();
        a[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000_0000L; i++) {
                a[0].x = i;
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000_0000L; i++) {
                a[1].x = i;
            }
        });
        final long start = System.nanoTime();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println((System.nanoTime() - start) / 100_0000L);
    }
}
