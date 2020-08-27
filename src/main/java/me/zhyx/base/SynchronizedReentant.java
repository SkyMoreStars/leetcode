package me.zhyx.base;

/**
 * @author: yx.zh
 * @date: 2020-07-13 20:36
 * sync可重入
 **/
public class SynchronizedReentant {
    synchronized void test1(){
        System.out.println(Thread.currentThread().getName()+"Running");
        test2();
    }

    synchronized void test2(){
        System.out.println(Thread.currentThread().getName()+"Running 1");
    }

    public static void main(String[] args) {
        SynchronizedReentant synchronizedReentant = new SynchronizedReentant();
        new Thread(synchronizedReentant::test1,"www ").start();
        new Thread(synchronizedReentant::test1,"ooo ").start();

    }
}
