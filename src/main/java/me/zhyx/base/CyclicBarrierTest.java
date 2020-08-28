package me.zhyx.base;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @auther zhyx
 * @Date 2020/6/19 11:19
 * @Description 所有线程都到达，然后继续执行，计数器递增，提供reset功能，可以多次使用
 */
public class CyclicBarrierTest {
    private int a;
    private int b;

    static class Thread1 implements Runnable {
        CyclicBarrier cyclicBarrier;
        CyclicBarrierTest cyclicBarrierTest;

        public Thread1(CyclicBarrier cyclicBarrier, CyclicBarrierTest cyclicBarrierTest) {
            this.cyclicBarrier = cyclicBarrier;
            this.cyclicBarrierTest = cyclicBarrierTest;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "执行");
            cyclicBarrierTest.setA(3);
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }

    static class Thread2 implements Runnable {
        CyclicBarrier cyclicBarrier;
        CyclicBarrierTest cyclicBarrierTest;

        public Thread2(CyclicBarrier cyclicBarrier, CyclicBarrierTest cyclicBarrierTest) {
            this.cyclicBarrier = cyclicBarrier;
            this.cyclicBarrierTest = cyclicBarrierTest;
        }

        @Override
        public void run() {

            System.out.println(Thread.currentThread().getName() + "执行");
            cyclicBarrierTest.setB(4);
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        final CyclicBarrierTest cyclicBarrierTest = new CyclicBarrierTest();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println(cyclicBarrierTest.sum(cyclicBarrierTest.a, cyclicBarrierTest.b) + "完成任务！");
            }
        });
        Thread1 thread1 = new Thread1(cyclicBarrier, cyclicBarrierTest);
        Thread2 thread2 = new Thread2(cyclicBarrier, cyclicBarrierTest);
        Thread t1 = new Thread(thread1, "线程1");
        t1.start();
        Thread t2 = new Thread(thread2, "线程2");
        t2.start();
    }

    public int getA() {
        return a;
    }

    public CyclicBarrierTest setA(int a) {
        this.a = a;
        return this;
    }

    public int getB() {
        return b;
    }

    public CyclicBarrierTest setB(int b) {
        this.b = b;
        return this;
    }

    public int sum(int a, int b) {
        return a + b;
    }
}
