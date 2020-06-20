package me.zhyx.base;

/**
 * @author: yx.zh
 * @date: 2020-06-20 14:38
 * lambda演化流程
 **/
public class TestLambda {
    /**
     * 静态内部类的实现方式
     */
//    static class Like1 implements ILike{
//        @Override
//        public void lambda() {
//            System.out.println("i like lambda1");
//        }
//    }
    public static void main(String[] args) {
//        ILike like0 = new Like();
//        like0.lambda();
//
//        ILike like1=new Like1();
//        like1.lambda();
//        /**
//         * 局部内部类
//         */
//        class Like2 implements ILike{
//
//            @Override
//            public void lambda() {
//                System.out.println("i like lambda2");
//            }
//        }
//        ILike like2=new Like2();
//        like2.lambda();
//        /**
//         * 匿名内部类
//         */
//        ILike like3=new ILike() {
//            @Override
//            public void lambda() {
//                System.out.println("i like lambda3");
//            }
//        };
//        like3.lambda();
        /**
         * lambda表达式
         */
        ILike like4=(name)->{
            System.out.println(name);
        };
        like4.lambda("i am zhyx");
    }
}
interface ILike{
     void lambda(String name);
}

/**
 * 普通实现方式
 */
//class Like implements ILike{
//
//    @Override
//    public void lambda() {
//        System.out.println("i like lambda0");
//    }
//}