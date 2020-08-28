package me.zhyx.base;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: yx.zh
 * @date: 2020-08-28 10:51
 **/
public class Container1<T> {
    final private LinkedList<T> linkedList = new LinkedList();
    final private int MAX = 10;
    private int count = 0;
    private Lock lock = new ReentrantLock();
    private Condition producer=lock.newCondition();
    private Condition consumer=lock.newCondition();
    public void put(T t){
        lock.lock();
        try{
            while (linkedList.size()==MAX){
                producer.await();
            }
            linkedList.add(t);
            ++count;
            consumer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public T get(){
        lock.lock();
        try{
            while (linkedList.size()==0){
                consumer.await();
            }
            T t= linkedList.removeFirst();
            --count;
            producer.signalAll();
            return t;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        Container1<Object> objectContainer = new Container1<>();
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
