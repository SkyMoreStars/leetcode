package me.zhyx.base;

import java.util.concurrent.Semaphore;

/**
 * @author: yx.zh
 * @date: 2020-08-27 15:31
 **/
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(5,true);
        for (int i = 0; i < 50; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"running!");
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName()+"over!");
                    System.out.println();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },"线程"+i).start();
        }
    }
}
