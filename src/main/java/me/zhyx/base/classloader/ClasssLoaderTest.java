package me.zhyx.base.classloader;

import java.io.File;

/**
 * @auther zhyx
 * @Date 2020/8/11 10:14
 * @Description
 */
public class ClasssLoaderTest extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        return super.findClass(name);
    }
}
