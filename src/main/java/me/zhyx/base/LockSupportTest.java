package me.zhyx.base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @author: yx.zh
 * @date: 2020-08-28 06:58
 **/
public class LockSupportTest {
    List list = new ArrayList();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    static Thread monitorT;
    static Thread excuseT;

    public static void main(String[] args) {
        LockSupportTest lockSupportTest = new LockSupportTest();
        monitorT = new Thread(() -> {
            System.out.println("监控线程启动！");
            LockSupport.park();
            System.out.println("监控线程结束！");
            LockSupport.unpark(excuseT);
        }, "监控线程");
        excuseT = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lockSupportTest.add(i);
                System.out.println(i);
                if (lockSupportTest.size() == 5) {
                    LockSupport.unpark(monitorT);
                    LockSupport.park();
                }
            }
        });
        monitorT.start();
        excuseT.start();
    }
}
