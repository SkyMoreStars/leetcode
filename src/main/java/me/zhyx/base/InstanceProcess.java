package me.zhyx.base;

import java.lang.reflect.Field;

/**
 * @auther zhyx
 * @Date 2020/8/11 13:33
 * @Description
 */
public class InstanceProcess {
    public static void main(String[] args) throws IllegalAccessException {
        A a = new A();
        a.m();

    }
}

class A {
    public volatile static int I=0;
    public String test="hello moc moc";
    static {
        System.out.println("Static");
    }
    public A() {
        System.out.println("A");
    }
    public synchronized void m(){
        System.out.println("B");
    }
}
