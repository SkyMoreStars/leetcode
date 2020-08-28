package me.zhyx.base;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @auther zhyx
 * @Date 2020/8/5 10:57
 * @Description
 */
public class WeakHashMapTest {

    static Map wMap = new WeakHashMap<String, String>();
    static Map map = new HashMap<String, String>();

    public static void main(String[] args) {
        init();
        testWeakHashMap();
        testHashMap();
    }

    private static void init() {
        String abc = "test";
        String bcd = "test";
        System.out.println(abc == bcd);
        String ref1 = new String("Object1");
        String ref2 = new String("Object2");
        System.out.println(ref1 == ref2);
        String ref3 = new String("Object3");
        String ref4 = new String("Object4");
        wMap.put(ref1, "test1");
        wMap.put(ref2, "test2");

        map.put(ref3, "test3");
        map.put(ref4, "test4");
        System.out.println("String引用ref1，ref2，ref3，ref4 消失");
    }

    public static void testWeakHashMap() {

        System.out.println("WeakHashMap GC之前");
        for (Object o : wMap.entrySet()) {
            System.out.println(o);
        }
        try {
            System.out.println("================");
            System.gc();
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("WeakHashMap GC之后");
        for (Object o : wMap.entrySet()) {
            System.out.println(o);
        }
        System.out.println("==========================");
    }

    public static void testHashMap() {
        System.out.println("HashMap GC之前");
        for (Object o : map.entrySet()) {
            System.out.println(o);
        }
        try {
            System.gc();
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("HashMap GC之后");
        for (Object o : map.entrySet()) {
            System.out.println(o);
        }
    }

}
