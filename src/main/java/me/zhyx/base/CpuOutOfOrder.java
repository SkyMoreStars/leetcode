package me.zhyx.base;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: yx.zh
 * @date: 2020-06-27 09:29
 * CPU乱序执行验证
 **/
public class CpuOutOfOrder {
    private static int a=0,y=0;
    private static int b=0,x=0;
    public static void main(String[] args) throws InterruptedException {
        int i=0;
        for (;;){
            i++;
            x=0;y=0;
            a=0;b=0;
            Thread t1 = new Thread(() -> {
                a = 1;
                x = b;
            });
            Thread t2 = new Thread(() -> {
                b = 1;
                y = a;
            });
            t1.start();t2.start();
            t1.join();t2.join();
            String result="第"+i+"次(x="+x+",y="+y+")";
            if(x==0&&y==0){
                System.err.println(result);
                break;
            }
        }
    }

    /**
     * @auther zhyx
     * @Date 2020/7/28 13:37
     * @Description
     */
    public static class ConcurrentHashMapTest {
        static class Key{
            private String test;

            public Key(String test) {
                this.test = test;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Key key = (Key) o;
                return Objects.equals(test, key.test);
            }

    //        @Override
    //        public int hashCode() {
    //            return 0x1111;
    //        }

            @Override
            public int hashCode() {
                return super.hashCode();
            }

            @Override
            public String toString() {
                return this.test;
            }
        }
        public static void main(String[] args) {
            Key key9 = new Key("9");
            ConcurrentHashMap<Key, Object> test = new ConcurrentHashMap<>();
            for(int i=0;i<1000;i++){
                test.put(new Key(""+i),"a"+i);
            }
        }
    }
}
