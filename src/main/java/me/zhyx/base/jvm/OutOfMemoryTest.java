package me.zhyx.base.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yx.zh
 * @date: 2020-08-06 22:32
 * -Xmx200M -Xms200M -XX:+PrintGC
 * OOM问题定位：
 * 1: 先使用top命令查询占用CPU最高的那个进程
 * 2: 通过jstack导出该进程堆栈信息,从堆栈信息中分析是否是垃圾回收线程runnable一直处于runnable状态
 * 3: 如果是则可能是OOM了。然后因为垃圾回收一直占用CPU
 * 4: 用jmap -hstio pid｜head -20 打印出前20行。分析对象信息。
 * 5: 如果jmap无法分析，在内存不是很大，且生产环境高可用的情况下，可以导出堆转储文件进行分析
 *      使用命令jmap dump:format=b,file=xx.log pid 然后通过mat进行分析等。
 * 或者gc日志也可以配置在文件中，
 **/
public class OutOfMemoryTest {
    private static class A{
        private byte[] bytes;

        public A() {
            this.bytes = new byte[1024*1024];
        }
    }
    private static class Thread1 extends Thread{
        List<A> list;

        public Thread1(String name, List<A> list) {
            super(name);
            this.list = list;
        }

        @Override
        public void run() {
            list.add(new A());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<A> as = new ArrayList<>();
        int i=0;
        while (true){
            new Thread1("线程"+i,as).start();
            Thread.sleep(100);
        }
    }
}
