package org.elsys.oop.packages.example;

//import org.elsys.oop.packages.Main;

import java.util.Comparator;

public class Person implements Comparable {
//    public void foo() {
//        Main m = new Main();
//    }
//    public static void foo() {
//
//    }

    public static class CompareNames implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    public String name;
    public int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        if(o == null || (o.getClass() != getClass())) return -1;
        Person other = (Person)o;

        return age - other.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
