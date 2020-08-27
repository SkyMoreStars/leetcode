package me.zhyx.base;

/**
 * @author: yx.zh
 * @date: 2020-07-13 20:27
 **/
public class SynchronizedTest {
    private static class Test {

        public synchronized void first(){
            System.out.println("开始跑第一个方法");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("开始跑第一个方法完成");

        }
        public void second(){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("跑完第二个方法");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
       new Thread(test::first,"test").start();
       new Thread(test::second,"test1").start();
       Thread.sleep(50000);
    }
}
