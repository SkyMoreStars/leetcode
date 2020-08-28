package me.zhyx.base;


import java.util.LinkedList;

/**
 * @author: yx.zh
 * @date: 2020-08-28 07:17
 **/
public class Container<T> {
    final private LinkedList<T> lists=new LinkedList<>();
    final private int MAX =10;
    private int count=0;

    public synchronized void put(T o){
        while (lists.size()==MAX){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lists.add(o);
        ++count;
        this.notifyAll();
    }
    public synchronized T get(){
        while (lists.size()==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T t = lists.removeFirst();
        count--;
        this.notifyAll();
        return t;

    }

    public static void main(String[] args) {
        Container<Object> objectContainer = new Container<>();
        Thread product1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                objectContainer.put(Thread.currentThread().getName() + " " + i);
            }
        }, "product1");
        Thread product2 = new Thread(() -> {
            for (int i = 100; i < 200; i++) {
                objectContainer.put(Thread.currentThread().getName() + " " + i);
            }
        }, "product2");
        product1.start();
        product2.start();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (true){
                    Object o = objectContainer.get();
                    System.out.println(o.toString());
                }
            },"consumer"+i).start();
        }
    }
}
