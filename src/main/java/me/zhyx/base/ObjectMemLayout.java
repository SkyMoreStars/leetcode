package me.zhyx.base;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author: yx.zh
 * @date: 2020-06-25 23:29
 **/
public class ObjectMemLayout {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
