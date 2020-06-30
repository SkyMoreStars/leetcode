package me.zhyx.base;

/**
 * @author: yx.zh
 * @date: 2020-06-30 19:26
 **/
public class VolatileTest {
    private static class Padding{
        private long p1,p2,p3,p4,p5,p6,p7;
    }
    private static class A extends Padding{
        private long b= 10000L;

        public A(long b) {
            this.b = b;
        }
    }
    private static A [] a=new A[2];
    static {
        a[0]=new A(10000L);
        a[1]=new A(10001L);
    }
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("正在执行");
            while (a[0].equals(10000L)){

            }
            System.out.println("执行结束");
        }).start();
        new Thread(()->{

        });
    }
}
