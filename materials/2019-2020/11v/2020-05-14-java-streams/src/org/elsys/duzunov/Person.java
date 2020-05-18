package org.elsys.duzunov;

import java.time.LocalDate;

public class Person implements Comparable<Person> {
    public enum Gender {
        MALE("male"),
        FEMALE("female");

        private final String shortName;

        Gender(String shortName) {
            this.shortName = shortName;
        }

        public String getShortName() {
            return shortName;
        }
    }

    private final String name;
    private final LocalDate birthday;
    private final Gender gender;
    private final String emailAddress;

    public Person(String name,
                  LocalDate birthday,
                  Gender gender,
                  String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public int getAge() {
        LocalDate today = LocalDate.now();
        LocalDate birthday = getBirthday();
        int age = today.getYear() - birthday.getYear();
        int monthDifference = today.getMonthValue() - birthday.getMonthValue();
        if (monthDifference < 0 ||
                (monthDifference == 0 &&
                        today.getDayOfMonth() < birthday.getDayOfMonth())) {
            --age;
        }
        return age;
    }

    public void print() {
        System.out.println(
                String.format(
                        "%s, %d, %s, %s",
                        getName(),
                        getAge(),
                        getGender().getShortName(),
                        getEmailAddress()
                )
        );
    }

    @Override
    public int compareTo(Person o) {
        return this.getName().compareTo(o.getName());
    }
}
