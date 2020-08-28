package me.zhyx.base.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @auther zhyx
 * @Date 2020/6/29 11:21
 * @Description
 */
public class MyLock implements Lock {
    private final MyAbstractQueuedSynchronized myAbstractQueuedSynchronized;

    public MyLock() {
        this.myAbstractQueuedSynchronized = new MyAbstractQueuedSynchronized();
    }

    @Override
    public void lock() {
        myAbstractQueuedSynchronized.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        myAbstractQueuedSynchronized.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        try {
            return myAbstractQueuedSynchronized.tryAcquireNanos(1, 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
            return false;
        }
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return myAbstractQueuedSynchronized.tryAcquireNanos(1, TimeUnit.NANOSECONDS.convert(time, unit));
    }

    @Override
    public void unlock() {
        myAbstractQueuedSynchronized.tryRelease(1);
    }

    @Override
    public Condition newCondition() {
        return myAbstractQueuedSynchronized.new ConditionObject();
    }

}
