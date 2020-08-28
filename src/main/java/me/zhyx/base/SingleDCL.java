package me.zhyx.base;

/**
 * @author: yx.zh
 * @date: 2020-06-27 09:57
 * DCL 双重检查锁。Double Check Lock
 **/
public class SingleDCL {
    private volatile static SingleDCL instance = null;

    private SingleDCL() {
    }

    public static SingleDCL getInstance() {
        if (instance == null) {
            synchronized (SingleDCL.class) {
                if (instance == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new SingleDCL();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(SingleDCL.getInstance().hashCode());
            }).start();
        }
    }
}
