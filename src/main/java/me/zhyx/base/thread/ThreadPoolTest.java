package me.zhyx.base.thread;

import java.util.LinkedList;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther zhyx
 * @Date 2020/8/11 15:50
 * @Description
 */
public class ThreadPoolTest {

    private static class ThreadA implements Runnable{

        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" start running");
            }
        }
    }
    private static class ThreadItem implements ThreadFactory{
        /**
         * 线程池编号
         */
        private final AtomicInteger poolNumber = new AtomicInteger(1);
        /**
         * 线程组
         */
        private final ThreadGroup threadGroup;
        /**
         * 线程池里面的第几个线程
         */
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        /**
         * 线程池的线程名称前缀
         */
        public  final String namePrefix;

        private ThreadItem(String name) {
            SecurityManager s = System.getSecurityManager();
            threadGroup = (s != null) ? s.getThreadGroup() :Thread.currentThread().getThreadGroup();
            if (null==name || "".equals(name.trim())){
                name = "pool";
            }
            namePrefix = name +"-"+
                    poolNumber.getAndIncrement() +
                    "-thread-";
        }


        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(threadGroup, r,namePrefix + threadNumber.getAndIncrement(),0);
            if (t.isDaemon()){
                t.setDaemon(false);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY){
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }
    public static void main(String[] args) {
        ThreadFactory threadItem = new ThreadItem("测试");
        BlockingQueue<Runnable> threadAS = new LinkedBlockingQueue<>(10);
        ThreadPoolExecutor.CallerRunsPolicy callerRunsPolicy = new ThreadPoolExecutor.CallerRunsPolicy();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4,6,3L,TimeUnit.HOURS,threadAS,threadItem,callerRunsPolicy);

        for(int i=0;i<18;i++){
            ThreadA threadA = new ThreadA();
            threadPoolExecutor.execute(threadA);
        }

    }
}
