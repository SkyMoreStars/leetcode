package me.zhyx.base;

/**
 * @author: yx.zh
 * @date: 2020-06-20 15:56
 **/
public class TestYield {
    public static void main(String[] args) {
        new Thread(new MyYield(),"a").start();
        new Thread(new MyYield(),"b").start();

    }
}
class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"执行结束");
    }
}