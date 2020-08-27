package me.zhyx.base.gc;


import java.util.ArrayList;
import java.util.List;

/**
 * @auther zhyx
 * @Date 2020/8/7 16:35
 * @Description
 * -Xmn10M -Xms40M -Xmx60M -Xmn50M -XX:+PrintCommandLineFlags -XX:+PrintGC PrintGCDetails PrintGCTimeStamps PrintGCCauses
 */
public class OutOfMemoryTest {
    private static class Thread1 extends Thread{
        private List<Object> list;

        public Thread1(String name, List<Object> list) {
            super(name);
            this.list = list;
        }

        @Override
        public void run() {
            System.out.println("开始填充");
            while (true){
                try {
                    Thread.sleep(100);
                    byte[] bytes = new byte[1024*1024];
                    list.add(bytes);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Object> bytes = new ArrayList<>();
        new Thread1("填充线程",bytes).start();
    }
}
