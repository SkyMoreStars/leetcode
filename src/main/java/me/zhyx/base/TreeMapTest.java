package me.zhyx.base;

import java.util.Map;
import java.util.TreeMap;

/**
 * @auther zhyx
 * @Date 2020/8/6 15:56
 * @Description
 */
public class TreeMapTest {
    private static class Student implements Comparable<Student> {
        private Integer studyNo;
        private String name;

        public Integer getStudyNo() {
            return studyNo;
        }

        public Student setStudyNo(Integer studyNo) {
            this.studyNo = studyNo;
            return this;
        }

        public String getName() {
            return name;
        }

        public Student setName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public int compareTo(Student o) {
            if (this.studyNo > o.studyNo) {
                return 1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return "Student{" +
                    "studyNo=" + studyNo +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        TreeMap<Student, String> studentStringTreeMap = new TreeMap<>();
        Student 张三 = new Student().setName("张三").setStudyNo(3);
        Student 李四 = new Student().setName("李四").setStudyNo(4);
        Student 王五 = new Student().setName("王五").setStudyNo(5);
        Student 赵六 = new Student().setName("赵六").setStudyNo(6);
        studentStringTreeMap.put(张三, "1");
        studentStringTreeMap.put(李四, "2");
        studentStringTreeMap.put(王五, "3");
        studentStringTreeMap.put(赵六, "4");
        for (Map.Entry<Student, String> studentStringEntry : studentStringTreeMap.entrySet()) {
            System.out.println(studentStringEntry.getKey() + "<===>" + studentStringEntry.getValue());
        }

        System.out.println("==================================");

        String replace = studentStringTreeMap.replace(张三, "1234");
        System.out.println(replace);
        for (Map.Entry<Student, String> studentStringEntry : studentStringTreeMap.entrySet()) {
            System.out.println(studentStringEntry.getKey() + "<===>" + studentStringEntry.getValue());
        }
    }
}
