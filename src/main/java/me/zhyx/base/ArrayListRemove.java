package me.zhyx.base;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: yx.zh
 * @date: 2020-07-06 23:44
 **/
public class ArrayListRemove {
    public static void main(String[] args) {
        HashSet<String> strings = new HashSet<>();
        strings.add(null);
        TreeMap<String, String> stringStringTreeMap = new TreeMap<>();
        stringStringTreeMap.put("2", "3");
        stringStringTreeMap.put("4", "5");
        for (Map.Entry<String, String> value : stringStringTreeMap.entrySet()) {
            System.out.println(value.getKey());
        }
    }
}
