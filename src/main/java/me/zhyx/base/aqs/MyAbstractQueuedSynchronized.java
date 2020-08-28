package me.zhyx.base.aqs;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author yssq
 * @auther zhyx
 * @Date 2020/6/29 11:12
 * @Description
 */
public class MyAbstractQueuedSynchronized extends AbstractQueuedSynchronizer {
    private final AtomicInteger state;

    public MyAbstractQueuedSynchronized() {
        this.state = new AtomicInteger(0);
    }

    @Override
    protected boolean tryAcquire(int arg) {
        return state.compareAndSet(0, 1);
    }

    @Override
    protected boolean tryRelease(int arg) {
        return state.compareAndSet(1, 0);
    }
}
