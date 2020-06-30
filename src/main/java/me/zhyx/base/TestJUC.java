package me.zhyx.base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: yx.zh
 * @date: 2020-06-20 20:22
 **/
public class TestJUC {
    public static void main(String[] args) throws InterruptedException {
        final ConcurrentHashMap<String,String> strings = new ConcurrentHashMap<>();
        List<Thread> threadArrayList = new ArrayList<Thread>();
        for (int i = 0; i < 100000; i++) {
            Thread thread = new Thread(() -> {
                strings.put(Thread.currentThread().getName(),"");
            });
            threadArrayList.add(thread);
        }
        threadArrayList.stream().forEach(t->{
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(strings.size());
    }
}
