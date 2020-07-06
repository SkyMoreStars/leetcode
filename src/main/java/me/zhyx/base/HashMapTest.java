package me.zhyx.base;

/**
 * @author: yx.zh
 * @date: 2020-07-04 13:08
 **/
public class HashMapTest {
    public static void main(String[] args) {
        System.out.println(comparator());
    }

    private static boolean comparator() {
        float a= 10.0f-9.0f;
        float b= 8.0f-7.0f;
        if(a==b){
            return true;
        }
        return false;
    }
}
