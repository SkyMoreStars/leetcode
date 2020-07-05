package me.zhyx.base;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author: yx.zh
 * @date: 2020-07-04 13:08
 **/
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        for(int i=0;i<8000;i++){
            stringIntegerHashMap.put(String.valueOf(i),i);
        }
        ArrayList<String> strings = new ArrayList<>();
        for (String s : stringIntegerHashMap.keySet()) {
            strings.add(s);
        }
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
