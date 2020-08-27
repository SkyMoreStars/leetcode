package me.zhyx.base;

import java.util.Random;
import java.util.concurrent.Phaser;


/**
 * @author: yx.zh
 * @date: 2020-08-27 14:31
 **/
public class PhaserTest {
    static Random r=new Random();
    static MarriagePhaser phaser=new MarriagePhaser();
    public static void main(String[] args) {
        phaser.bulkRegister(7);
        for (int i = 0; i < 5; i++) {
            new Thread(new Marriage("宾客"+i)).start();
        }
        new Thread(new Marriage("新郎")).start();
        new Thread(new Marriage("新娘")).start();

    }
    static class Marriage implements Runnable{
        private String name;

        public Marriage(String name) {
            this.name = name;
        }
        public void arrive(){
            startSleep(r.nextInt(10000));
            System.out.println(this.name+"到了！");
            phaser.arriveAndAwaitAdvance();
        }
        public void eat(){
            startSleep(r.nextInt(10000));
            System.out.println(this.name+"开始吃！");
            phaser.arriveAndAwaitAdvance();
        }
        public void leave(){
            startSleep(r.nextInt(10000));
            System.out.println(this.name+"离开了！");
            phaser.arriveAndAwaitAdvance();
        }
        public void hug(){
            if(this.name.equals("新郎")||this.name.equals("新娘")){
                System.out.println("新郎新娘入洞房！");
                phaser.arriveAndAwaitAdvance();
            }else {
                phaser.arriveAndDeregister();
            }
        }
        private void startSleep(int nextInt) {
            try {
                Thread.sleep(nextInt);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            arrive();
            eat();
            leave();
            hug();
        }
    }
    static class MarriagePhaser extends Phaser{
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase){
                case 0:
                    System.out.println("所有人到齐了！"+registeredParties);
                    System.out.println();
                    return false;
                case 1:
                    System.out.println("所有人吃完了！"+registeredParties);
                    System.out.println();
                    return false;
                case 2:
                    System.out.println("所有人离开了！"+registeredParties);
                    System.out.println();
                case 3:
                    System.out.println("婚礼结束！新郎新娘拥抱！"+registeredParties);
                    return true;
                default:
                    return false;
            }
        }
    }


}
