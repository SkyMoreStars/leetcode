package me.zhyx;

/**
 * @author: yx.zh
 * @date: 2020-08-01 01:51
 * -Xint -Xcomp
 **/
public class ClassLoading {
    public static void main(String[] args) {
        for(int i=0;i<10_0000;i++){
            m();
        }
        long start = System.currentTimeMillis();

        for(int i=0;i<10_0000;i++){
            m();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
    public static void m(){
        for(int i=0;i<10_0000L;i++){
            long j=i%3;
        }
    }
}
