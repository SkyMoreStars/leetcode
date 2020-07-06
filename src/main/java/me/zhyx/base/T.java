package me.zhyx.base;

import java.lang.reflect.Field;

/**
 * @auther zhyx
 * @Date 2020/7/1 8:54
 * @Description
 */
public class T {
    public final int value;
    public T(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        T t = new T(1);
        Field value = T.class.getDeclaredField("value");
        value.setAccessible(true);
        value.setInt(t,4);
        System.out.println(t.value);
    }
}
