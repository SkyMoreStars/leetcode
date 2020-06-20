package me.zhyx.base;

import sun.jvm.hotspot.oops.BranchData;

import java.util.Random;

/**
 * @author: yx.zh
 * @date: 2020-06-20 09:11
 **/
public class Race implements Runnable{
    private volatile static String winner="";
    private static int DESTINATION=100;
    private static Random random=new Random(100);
    private String track="";
    private int rest;
    /**
     * 步数
     */
    private int step;

    public Race() {
        step=0;
    }

    @Override
    public synchronized void run() {
        while (true){
            //判断有没有人到达终点
            if("".equals(winner)){
                if(this.step>=DESTINATION){
                    winner=Thread.currentThread().getName();
                    System.out.println(Thread.currentThread().getName()+"赢了");
                    break;
                }
            }else {
                break;
            }
            //乌龟或兔子每次跑随机步数
            int i = random.nextInt(3);
            System.out.println("===============================================================");
            printTrack(i);
            try {
                if(Thread.currentThread().getName().equals("兔子")){
                    int rest = random.nextInt(400) + 100;
                    this.rest+=rest;
                    Thread.sleep(rest);
                    System.out.print("兔子跑了"+this.step+"步，总共休息了"+this.rest+"ms");
                }else {
                    Thread.sleep(200);
                    this.rest+=200;
                    System.out.print("乌龟跑了"+this.step+"步，总共休息了"+rest+"ms");

                }
                System.out.println("---》"+Thread.currentThread().getName());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printTrack(int i) {
        StringBuilder builder=new StringBuilder();
        for (int i1 = 0; i1 < i; i1++) {
            builder.append("*");
        }
        this.step+=i;
        this.track+=builder.toString();
        System.out.print(this.track);
    }

    public static void main(String[] args) {
        Race wugui = new Race();
        Race tuzi = new Race();
        new Thread(wugui,"乌龟").start();
        new Thread(tuzi,"兔子").start();
    }
}
