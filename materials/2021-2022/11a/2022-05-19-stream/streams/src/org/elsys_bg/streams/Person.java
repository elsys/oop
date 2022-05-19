package org.elsys_bg.streams;

public class Person {
    private String name;
    private Sex gender;
    public enum Sex {
        MALE, FEMALE
    }
    private int age;

    public Person(String name, Sex gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Sex getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}
