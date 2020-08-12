package me.zhyx.base.sortexcuse;

import me.zhyx.base.ReentantLockDemo;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

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

    public static void main(String[] args) throws InterruptedException {
//        countDownLatchMethodExcuse();
        
//        joinMethodExcuse();

//        reentrantLockExcuse();
        
            waitAndNotifyExcuse();
    }

    /**
     * 负责打印数字
     */
    private static class ThreadA implements Runnable{
        private int [] arr={1,2,3,4,5,6,7,8,9};
        Object lockObj;

        public ThreadA(Object lockObj) {
            this.lockObj = lockObj;
        }

        @Override
        public void run() {
            synchronized (lockObj){
                for (int i : arr) {
                    lockObj.notify();
                    System.out.println(Thread.currentThread().getName()+":"+i);
                    try {
                        lockObj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lockObj.notify();
            }

        }
    }

    /**
     * 复杂打印字母
     */
    private static class ThreadB implements Runnable{
        private char[] letters={'A','B','C','D','E','F','G','H','I'};
        Object lockObj;

        public ThreadB(Object lockObj) {
            this.lockObj = lockObj;
        }

        @Override
        public void run() {
            synchronized (lockObj){
                for (char letter : letters) {
                    lockObj.notify();
                    System.out.println(Thread.currentThread().getName()+":"+letter);
                    try {
                        lockObj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lockObj.notify();
            }

        }
    }
    private static void waitAndNotifyExcuse() throws InterruptedException {
        Object o = new Object();
        new Thread(new ThreadA(o), "线程A").start();
        Thread.sleep(1);
        new Thread(new ThreadB(o), "线程B").start();
    }

    private static class ThreadReentrantLock extends Thread{
        ReentrantLock reentrantLock;

        public ThreadReentrantLock(String name, ReentrantLock reentrantLock) {
            super(name);
            this.reentrantLock = reentrantLock;
        }

        @Override
        public void run() {
            reentrantLock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"开始执行");
            }catch (Exception e){

            }finally {
                reentrantLock.unlock();
            }
        }
    }
    private static void reentrantLockExcuse() {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        ArrayList<ThreadReentrantLock> threadReentrantLockArrayList = new ArrayList<ThreadReentrantLock>();
        for(int i=0;i<10;i++){
            ThreadReentrantLock threadReentrantLock = new ThreadReentrantLock("线程"+i,reentrantLock);
            threadReentrantLockArrayList.add(threadReentrantLock);
        }

        threadReentrantLockArrayList.forEach((item)->{
            item.start();
            try {
                item.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
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
