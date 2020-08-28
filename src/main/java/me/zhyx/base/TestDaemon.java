package me.zhyx.base;

/**
 * @author: yx.zh
 * @date: 2020-06-20 16:43
 **/
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        YouSelf youSelf = new YouSelf();
        Thread thread = new Thread(god);
        thread.setDaemon(true);
        thread.start();
        new Thread(youSelf).start();
    }
}

class God implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("上帝保佑着你！");
        }
    }
}

class YouSelf implements Runnable {

    @Override
    public void run() {
        System.out.println("出生开始努力活着！");
        for (int i = 0; i < 36500; i++) {
            System.out.println("活着的第" + i + "天");
        }
        System.out.println("人生短短不过36500天，再见来世界！");
    }
}