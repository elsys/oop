package org.elsys_bg.lambda;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    private String name;
    public enum SEX {
        MALE, FEMALE
    }
    private SEX gender;
    private LocalDate birthday;
    private String email;

    public Person(String name, SEX gender, LocalDate birthday, String email) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
    }

    public int getAge() {
        LocalDate now = LocalDate.now();
        return Period.between(birthday, now).getYears();
    }

    public SEX getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                '}';
    }
}
