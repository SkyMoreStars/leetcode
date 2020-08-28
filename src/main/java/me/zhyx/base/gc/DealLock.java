package me.zhyx.base.gc;

/**
 * @auther zhyx
 * @Date 2020/8/7 16:16
 * @Description
 */
public class DealLock {

    private static class A {

    }

    private static class B {

    }

    private static class Thread1 extends Thread {
        private A a;
        private B b;

        public Thread1(String name, A a, B b) {
            super(name);
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (A.class) {
                try {
                    Thread.sleep(199);
                    synchronized (B.class) {

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Thread2 extends Thread {
        private A a;
        private B b;

        public Thread2(String name, A a, B b) {
            super(name);
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (B.class) {
                try {
                    Thread.sleep(199);
                    synchronized (A.class) {

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
        new Thread1("线程1", a, b).start();
        new Thread2("线程2", a, b).start();

    }
}
