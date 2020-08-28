package me.zhyx.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @auther zhyx
 * @Date 2020/7/7 10:18
 * @Description
 */
public class ListRemoveForLambda {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("test");
        strings.add("werwer");
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            iterator.remove();
        }
        System.out.println(Arrays.toString(strings.toArray()));
    }
}
