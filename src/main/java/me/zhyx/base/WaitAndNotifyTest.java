package me.zhyx.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yx.zh
 * @date: 2020-08-28 07:09
 **/
public class WaitAndNotifyTest {
    List list = new ArrayList();
    public void add(Object o){
        list.add(o);
    }
    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        WaitAndNotifyTest waitAndNotifyTest = new WaitAndNotifyTest();
        final Object o=new Object();
        Thread monitorT = new Thread(()->{
            synchronized (o){
                try {
                    System.out.println("监控线程启动！");
                    o.wait();
                    System.out.println("监控线程结束！");
                    o.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread excuseT=new Thread(()->{
            synchronized (o){
                for (int i = 0; i < 10; i++) {
                    if(waitAndNotifyTest.size()==5){
                        o.notify();
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(i);
                    waitAndNotifyTest.add(i);
                }
            }
        });
        monitorT.start();
        excuseT.start();
    }
}
