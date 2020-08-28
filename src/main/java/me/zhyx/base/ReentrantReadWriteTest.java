package me.zhyx.base;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: yx.zh
 * @date: 2020-08-27 15:09
 **/
public class ReentrantReadWriteTest {
    static int hello = 0;
    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock write = readWriteLock.writeLock();

    public static void main(String[] args) {
        ReentrantReadWriteTest r = new ReentrantReadWriteTest();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                r.read(readLock);
            }).start();
        }
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            new Thread(() -> {
                r.write(write, finalI);
            }).start();
        }
    }

    public void read(Lock lock) {
        lock.lock();
        try {
            Thread.sleep(1000);
            System.out.println("lock over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void write(Lock lock, int value) {
        lock.lock();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        hello = value;
        System.out.println("hello value is " + hello);
        System.out.println("write over");
    }
}
