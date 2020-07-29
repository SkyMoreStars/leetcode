package me.zhyx.base;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @auther zhyx
 * @Date 2020/7/28 13:37
 * @Description
 */
public class ConcurrentHashMapTest {
    static class Key{
        private String test;

        public Key(String test) {
            this.test = test;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return Objects.equals(test, key.test);
        }

//        @Override
//        public int hashCode() {
//            return 0x1111;
//        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public String toString() {
            return this.test;
        }
    }
    public static void main(String[] args) {
        Key key9 = new Key("9");
        ConcurrentHashMap<Key, Object> test = new ConcurrentHashMap<>();
        for(int i=0;i<1000;i++){
            test.put(new Key(""+i),"a"+i);
        }
    }
}
