package me.zhyx.base;

/**
 * @auther zhyx
 * @Date 2020/8/11 10:59
 * @Description
 */
public class VolatileTests {
    public static volatile int i;
    public static Object object=new Object();
    private static class Thread1 extends Thread{
        public Thread1(String name) {
            super(name);
        }

        @Override
        public void run() {
              synchronized (object){
                  for(int i=0;i<20;i++){
                      VolatileTests.i++;
                      System.out.println(Thread1.currentThread().getName()+" :"+VolatileTests.i);
                  }
              }
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<1000;i++){
            Thread1 thread1 = new Thread1("test"+i);
            thread1.start();
        }
    }
}
