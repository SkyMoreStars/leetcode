package me.zhyx.base;

/**
 * @auther zhyx
 * @Date 2020/6/19 9:36
 * @Description
 */
public class ReentantLockTest {
    private static ReentantLockDemo reentantLockDemo = new ReentantLockDemo();
    public static void main(String[] args) throws InterruptedException {
        ReentantLockTest reentantLockTest = new ReentantLockTest();
        new Thread(()->{
            reentantLockTest.a();
        },"test1").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            reentantLockTest.a();
        },"test2").start();
        new Thread(()->{
            reentantLockTest.a();
        },"test3").start();
    }
    private void a(){
        if(Thread.currentThread().getName().equals("test2")){
            System.out.println("等待");
        }
        reentantLockDemo.lock();
        System.out.println("a");
        b();
        reentantLockDemo.unlock();
    }

    private void b() {
        reentantLockDemo.lock();
        System.out.println("b");
        reentantLockDemo.unlock();
    }
}
