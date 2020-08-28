package me.zhyx.base;

/**
 * @author: yx.zh
 * @date: 2020-06-20 19:36
 **/
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket, "苦逼的你").start();
        new Thread(buyTicket, "牛逼的你们").start();
        new Thread(buyTicket, "可恶的黄牛党").start();

    }
}

class BuyTicket implements Runnable {
    //票
    private int ticketNum = 10;
    private boolean flag = true;

    @Override
    public void run() {
        //买票
        while (flag) {
            try {

                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void buy() throws InterruptedException {
        Thread.sleep(100);
        if (this.ticketNum <= 0) {
            flag = false;
            return;
        }
        //买票
        System.out.println(Thread.currentThread().getName() + "拿到第" + ticketNum-- + "票");
    }
}