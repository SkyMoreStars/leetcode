package me.zhyx.base;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Stream;

/**
 * @auther zhyx
 * @Date 2020/6/19 16:30
 * @Description
 */
public class Horse implements Runnable {
    private static int counter = 0;
    private final int id= counter++;
    private int strides=0;
    private static Random random=new Random(47);
    private static CyclicBarrier cyclicBarrier;

    public Horse(CyclicBarrier cyclicBarrier) {
        Horse.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                synchronized(this){
                    /**
                     * 赛马每次跑几步
                     */
                    strides+=random.nextInt(3);
                }
                cyclicBarrier.await();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String tracks() {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < getStrides(); i++) {
            s.append("*");
        }
        s.append(id);
        return s.toString();
    }

    public synchronized int getStrides() { return strides; }
    @Override
    public String toString() {
        return "Horse " + id + " ";
    }
}

class HorseRace implements Runnable{
    private static final int FINISH_LINE = 217;
    private static List<Horse> horses = new ArrayList<Horse>();
    private static ExecutorService exec = Executors.newCachedThreadPool();


    @Override
    public void run() {
        StringBuilder s = new StringBuilder();
        //打印赛道边界
        for(int i = 0; i < FINISH_LINE; i++) {
            s.append("=");
        }
        System.out.println(s);
        //打印赛马轨迹
        for(Horse horse : horses) {
            System.out.println(horse.tracks());
        }
        //判断是否结束
        for(Horse horse : horses) {
            if(horse.getStrides() >= FINISH_LINE) {
                System.out.println(horse + "won!");
                exec.shutdownNow();
                horses.stream().sorted(Comparator.comparing(Horse::getStrides).reversed()).forEach(horse1-> System.out.println(horse1));
                return;
            }

        }

        //休息指定时间再到下一轮
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("barrier-action sleep interrupted");
        }
    }
    public static void main(String[] args) {
        System.out.println("*********************************".length());
        CyclicBarrier barrier = new CyclicBarrier(10, new HorseRace());
        for(int i = 0; i < 11; i++) {
            Horse horse = new Horse(barrier);
            horses.add(horse);
            exec.execute(horse);
        }
    }

}
