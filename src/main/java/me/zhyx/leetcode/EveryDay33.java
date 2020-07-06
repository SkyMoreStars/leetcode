package me.zhyx.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther zhyx
 * @Date 2020/7/1 8:20
 * @Description
 */
public class EveryDay33 {
    /**
     * 罗马数字转换成Int
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int[] num = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if ((i + 1 < chars.length) && chars[i] == 'I' && (chars[i + 1] == 'V' || chars[i + 1] == 'X')) {
                num[i] = -charToInt(chars[i]);
                continue;
            }
            if ((i + 1 < chars.length) && chars[i] == 'X' && (chars[i + 1] == 'L' || chars[i + 1] == 'C')) {
                num[i] = -charToInt(chars[i]);
                continue;
            }
            if ((i + 1 < chars.length) && chars[i] == 'C' && (chars[i + 1] == 'D' || chars[i + 1] == 'M')) {
                num[i] = -charToInt(chars[i]);
                continue;
            }
            num[i] = charToInt(chars[i]);
        }
        int sum = 0;
        for (int i : num) {
            sum += i;
        }
        return sum;
    }

    public int charToInt(char a) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map.get(a);
    }

    public static void main(String[] args) {
        EveryDay33 everyDay33 = new EveryDay33();
        System.out.printf("最后结果为：%d", everyDay33.romanToInt("MDCLXVI"));
    }
}
