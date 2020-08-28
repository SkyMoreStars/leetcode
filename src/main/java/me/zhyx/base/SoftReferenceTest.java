package me.zhyx.base;

import java.lang.ref.SoftReference;

/**
 * @author: yx.zh
 * @date: 2020-06-27 13:04
 * VM:-Xmx20M
 **/
public class SoftReferenceTest {

    public static void main(String[] args) {
        SoftReference<byte[]> softReference = new SoftReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(softReference.get());
        System.gc();
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(softReference.get());
        byte[] b = new byte[1024 * 1024 * 10];
        System.out.println(softReference.get());
    }
}
