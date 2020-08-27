package me.zhyx.base;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author: yx.zh
 * @date: 2020-08-27 14:15
 **/
public class CyclicBarrierTests {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(20);
        for (int i = 0; i < 101; i++) {
            new Thread(()->{
                            try {
                                cyclicBarrier.await();
                                System.out.println(Thread.currentThread().getName()+"开始跑");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (BrokenBarrierException e) {
                                e.printStackTrace();
                            }

                        }, "线程"+i).start();
        }
    }
}
