package me.zhyx.base;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @auther zhyx
 * @Date 2020/6/19 9:26
 * @Description
 */
public class ReentantLockDemo implements Lock {
    /**
     * 是否持有锁
     */
    private volatile boolean isHoldLock = false;
    /**
     * 记录获得锁的线程
     */
    Thread currentThread = null;
    /**
     * 记录获得锁的线程的重入次数
     */
    private volatile int num = 0;

    @Override
    public synchronized void lock() {
        System.out.println("线程" + Thread.currentThread().getName() + "开始获得锁");
        if (isHoldLock && currentThread != Thread.currentThread()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        currentThread = Thread.currentThread();
        System.out.println("线程" + Thread.currentThread().getName() + "第一次获得锁");
        if (num != 0) {
            System.out.println("线程" + Thread.currentThread().getName() + "重入锁" + (num + 1));
        }
        num++;

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public synchronized void unlock() {
        if (Thread.currentThread() == currentThread) {
            System.out.println("线程" + Thread.currentThread().getName() + "释放锁，第" + num + "次释放");
            num--;
            if (num == 0) {
                System.out.println("线程" + Thread.currentThread().getName() + "释放锁完毕");
                notify();
                isHoldLock = false;
            }
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
