package me.zhyx.base;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author: yx.zh
 * @date: 2020-07-07 01:48
 **/
public class LambdaTest {
    private static class Person {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public Person setName(String name) {
            this.name = name;
            return this;
        }

        public int getAge() {
            return age;
        }

        public Person setAge(int age) {
            this.age = age;
            return this;
        }
    }

    private List<Person> personlist;

    private List<Person> makepersonlist() {
        List<Person> list = new ArrayList<Person>();
        Person person1 = new Person();
        person1.setAge(10);
        person1.setName("zhangsan");
        list.add(person1);
        Person person2 = new Person();
        person2.setAge(12);
        person2.setName("lisi");
        list.add(person2);
        Person person3 = new Person();
        person3.setAge(5);
        person3.setName("wangwu");
        list.add(person3);
        return list;
    }

    public void filterWithoutStream() {
        List<String> nameList = new ArrayList<>();
        this.personlist = makepersonlist();
        for (Person person : personlist) {
            if (person.getAge() >= 10) {
                nameList.add(person.getName());
            }
        }
        for (String name : nameList) {
            System.out.println(name);
        }
    }

    public void filterWithStreamAndLambda() {
        //TODO: 补充代码
        List<String> nameList = new ArrayList<>();

        makepersonlist().stream().filter(person -> {
            if (person.age > 30) {
                return true;
            }
            return false;
        }).forEach(item -> {
            nameList.add(item.name);
        });

    }


}
