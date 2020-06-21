package me.zhyx.base;

/**
 * @author: yx.zh
 * @date: 2020-06-21 08:02
 **/
public class SyncDemo {
    public synchronized void print(){
        System.out.println(Thread.currentThread().getName());
        printf();
    }

    private synchronized void printf() {
        System.out.println(Thread.currentThread().getName());

    }

    public static void main(String[] args) {
        SyncDemo syncDemo = new SyncDemo();
        syncDemo.print();
    }
}
