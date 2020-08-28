package me.zhyx.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: yx.zh
 * @date: 2020-06-21 09:31
 * 线程信号灯通讯
 **/
public class TestPC1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        TV tv = new TV();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}

/**
 * 演员
 */
class Player extends Thread {
    TV tv;

    public Player(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {

                if (i % 2 == 0) {
                    tv.play("快乐大本营！");
                } else {
                    tv.play("广告！");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

/**
 * 观众
 */
class Watcher extends Thread {
    TV tv;

    public Watcher(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                tv.watch();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * TV
 */
class TV {
    /**
     * 演员表演，观众等待T
     * 观众观看，演员等待F
     */

    String voice;
    boolean flag = true;

    public synchronized void play(String voice) throws InterruptedException {
        if (!flag) {
            wait();
        }
        System.out.println("演员表演了：" + voice);
        this.notifyAll();
        this.voice = voice;
        this.flag = !this.flag;

    }

    /**
     * 观众看节目
     */
    public synchronized void watch() throws InterruptedException {
        if (flag) {
            wait();
        }
        System.out.println("观众观看了：" + this.voice);
        this.notifyAll();
        this.flag = !this.flag;

    }
}
