package me.zhyx.base.aqs;

import java.util.concurrent.TimeUnit;

/**
 * @auther zhyx
 * @Date 2020/6/29 11:27
 * @Description
 */
public class MyThread implements Runnable{
    private final MyLock lock;
    private final String name;
    public MyThread(MyLock lock, String name) {
        this.lock = lock;
        this.name = name;
    }

    @Override
    public void run() {
        lock.lock();
        System.out.printf("Task: %s: Take the lock\n",name);
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.printf("Task: %s: Free the lock\n",name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
