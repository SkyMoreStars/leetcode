package me.zhyx.base;

/**
 * @author: yx.zh
 * @date: 2020-06-20 13:55
 * 静态代理demo
 **/
@FunctionalInterface
public interface Merry {
    /**
     * 结婚方法
     */
    void wedding();
}

class You implements Merry {
    @Override
    public void wedding() {
        System.out.println("我要结婚了，我只负责结婚。其他事情别人帮我来办理！");
    }
}

class MerryCompany implements Merry {
    private Merry target;

    public MerryCompany(Merry target) {
        this.target = target;
    }

    @Override
    public void wedding() {
        before();
        target.wedding();
        after();
    }

    private void after() {
        System.out.println("送客收尾款，打扫卫生！");
    }

    private void before() {
        System.out.println("布置婚礼现场，迎宾，安排坐席！");
    }
}