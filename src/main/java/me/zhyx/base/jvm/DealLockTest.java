package me.zhyx.base.jvm;

/**
 * @author: yx.zh
 * @date: 2020-08-06 22:17
 * 线程死锁分析：
 * 1: 使用jps找出当前线程的pid
 * 2：使用jstack+ pid打印出堆栈信息。通过waiting lock可以分析出哪个线程持有了这把锁。
 **/
public class DealLockTest {
    private static class A{

    }

    private static class B{

    }
    private static class Thread1 implements Runnable{
        private A a;
        private B b;

        public Thread1(A a, B b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (a){
                try {
                    System.out.println(Thread.currentThread().getName()+"lock a finish");
                    Thread.sleep(100);
                    synchronized (b){
                        System.out.println("start do something");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static  class Thread2 implements Runnable{
        private A a;
        private B b;

        public Thread2(A a, B b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (b){
                try {
                    System.out.println(Thread.currentThread().getName()+"lock b finish");
                    Thread.sleep(100);
                    synchronized (a){
                        System.out.println("start do something");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        Thread1 thread1 = new Thread1(a, b);
        Thread2 thread2 = new Thread2(a, b);
        new Thread(thread1,"线程1").start();
        new Thread(thread2,"线程2").start();
    }
}
