package org.elsys_bg.lambda;

public class Person implements Cloneable {
    private String name;
    private int age;
    private int grade;


    public Person(String name, int age, int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public boolean isOldEnough() {
        return age > 18;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
