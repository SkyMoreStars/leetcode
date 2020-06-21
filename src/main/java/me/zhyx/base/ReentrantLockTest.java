package me.zhyx.base;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: yx.zh
 * @date: 2020-06-20 20:41
 **/
public class ReentrantLockTest {
    public static void main(String[] args) {
        BuyTicketThread buyTicketThread = new BuyTicketThread();
        new Thread(buyTicketThread,"苦逼的我").start();
        new Thread(buyTicketThread,"牛逼的你").start();
        new Thread(buyTicketThread,"可恶的黄牛").start();
    }
}

class BuyTicketThread implements Runnable {
    int ticketNum = 10;
    ReentrantLock reentrantLock = new ReentrantLock();
    int countThread=0;
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {
            reentrantLock.lock();
            try {
                if(Thread.currentThread().getName().equals("苦逼的我")){
                    countThread++;
                    System.out.println("线程重入次数："+countThread);
                }
                if (ticketNum > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"抢到来第"+ticketNum--+"票");
                } else {
                    break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
                countThread--;
            }
        }
    }
}