package me.zhyx.base.sortexcuse;

import java.util.concurrent.CountDownLatch;

/**
 * @auther zhyx
 * @Date 2020/7/6 9:03
 * @Description
 */
public class SortThreadDemo {
    private static class Thread1 extends Thread {
        CountDownLatch countDownLatch;

        public Thread1(CountDownLatch countDownLatch,String name) {
            super(name);
            this.countDownLatch = countDownLatch;
        }

        public Thread1(String name) {
            super(name);
        }

        @Override
        public void run() {
            if(countDownLatch!=null){
                countDownLatch.countDown();
            }
            System.out.println("当前线程是："+Thread.currentThread().getName());
        }
    }
    private static class Thread2 extends Thread {
        CountDownLatch countDownLatch;

        public Thread2(CountDownLatch countDownLatch,String name) {
            super(name);
            this.countDownLatch = countDownLatch;
        }

        public Thread2(String name) {
            super(name);
        }

        @Override
        public void run() {
            if(countDownLatch!=null){
                countDownLatch.countDown();
            }
            System.out.println("当前线程是："+Thread.currentThread().getName());
        }
    }
    private static class Thread3 extends Thread {
        CountDownLatch countDownLatch;

        public Thread3(CountDownLatch countDownLatch,String name) {
            super(name);
            this.countDownLatch = countDownLatch;
        }

        public Thread3(String name) {
            super(name);
        }

        @Override
        public void run() {
            if(countDownLatch!=null){
                countDownLatch.countDown();
            }
            System.out.println("当前线程是："+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        countDownLatchMethodExcuse();
        
//        joinMethodExcuse();

    }

    private static void countDownLatchMethodExcuse() {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Thread1 thread1 = new Thread1(countDownLatch,"线程1");
        Thread2 thread2 = new Thread2(countDownLatch,"线程2");
        Thread3 thread3 = new Thread3(countDownLatch,"线程3");
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void joinMethodExcuse() {
        Thread1 thread1 = new Thread1("线程1");
        Thread2 thread2 = new Thread2("线程2");
        Thread3 thread3 = new Thread3("线程3");
        try {
            thread1.start();
            thread1.join();
            thread2.start();
            thread2.join();
            thread3.start();
            thread3.join();
        }catch (Exception e){
            System.out.println("异常");
        }
    }
}
