package me.zhyx.base;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @auther zhyx
 * @Date 2020/7/31 11:46
 * @Description
 */
public class Invocation implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxy,args);
    }
}
