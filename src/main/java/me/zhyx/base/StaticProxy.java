package me.zhyx.base;

/**
 * @author: yx.zh
 * @date: 2020-06-20 14:02
 **/
public class StaticProxy {
    public static void main(String[] args) {
        MerryCompany merryCompany = new MerryCompany(new You());
        merryCompany.wedding();
    }
}
