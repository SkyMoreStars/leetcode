package me.zhyx.base;

/**
 * @author: yx.zh
 * @date: 2020-06-27 09:29
 * CPU乱序执行验证
 **/
public class CpuOutOfOrder {
    private static int a=0,y=0;
    private static int b=0,x=0;
    public static void main(String[] args) throws InterruptedException {
        int i=0;
        for (;;){
            i++;
            x=0;y=0;
            a=0;b=0;
            Thread t1 = new Thread(() -> {
                a = 1;
                x = b;
            });
            Thread t2 = new Thread(() -> {
                b = 1;
                y = a;
            });
            t1.start();t2.start();
            t1.join();t2.join();
            String result="第"+i+"次(x="+x+",y="+y+")";
            if(x==0&&y==0){
                System.err.println(result);
                break;
            }
        }
    }
}
