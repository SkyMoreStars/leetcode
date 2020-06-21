package me.zhyx.base;

/**
 * @author: yx.zh
 * @date: 2020-06-21 08:09
 * synchronized死锁demo
 * 两个女孩要化妆，都需要镜子和口红。
 *
 **/
public class SyncDealLock {
    public static void main(String[] args) {
        Lipstick lipstick = new Lipstick();
        Mirror mirror = new Mirror();
        new Thread(new MakeUp(mirror,lipstick),"girl1").start();
        new Thread(new MakeUp(mirror,lipstick),"girl2").start();
    }

}

/**
 * 镜子
 */
class Mirror{

}

/**
 * 口红
 */
class Lipstick{

}

class MakeUp implements Runnable{
    Mirror mirror;
    Lipstick lipstick;

    public MakeUp(Mirror mirror, Lipstick lipstick) {
        this.mirror = mirror;
        this.lipstick = lipstick;
    }

    @Override
    public void run() {
        /**
         * 模拟两个女孩先一个先拿镜子，一个先拿口红的场景
         * 互相等待对方把镜子/口红用完
         */
        if(Thread.currentThread().getName().equals("girl1")){
            synchronized (mirror){
                System.out.println("girl1 拿到镜子");
                System.out.println("girl1 开始拿口红");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lipstick){
                    System.out.println("girl1开始化妆");
                }
            }
        }
        if(Thread.currentThread().getName().equals("girl2")){
            synchronized (lipstick){
                System.out.println("girl2 拿到口红");
                System.out.println("girl2 开始拿镜子");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mirror){
                    System.out.println("girl2开始化妆");
                }
            }
        }
    }
}