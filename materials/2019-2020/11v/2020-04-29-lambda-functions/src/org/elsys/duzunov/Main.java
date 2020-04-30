package org.elsys.duzunov;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    private interface PersonCriteria {
        boolean isSatisfiedFor(Person person);
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(
                Arrays.asList("a1", "vivacom", "telenor", "mtel")
        );

        // Локален клас
        class StringLengthComparator implements Comparator<String> {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        }
        strings.sort(new StringLengthComparator());

        // Анонимен клас
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        // Ламбда функция (анонимна функция)
        strings.sort((o1, o2) -> Integer.compare(o1.length(), o2.length()));

        for (var string : strings) {
            System.out.println(string);
        }
        System.out.println();

        List<Person> people = new ArrayList<>();
        people.add(
                new Person(
                        "Ivan",
                        LocalDate.of(2001, 12, 20),
                        Person.Gender.MALE,
                        "ivan@gmail.com"
                )
        );
        people.add(
                new Person(
                        "Yordan",
                        LocalDate.of(1998, 12, 20),
                        Person.Gender.MALE,
                        "yordan@gmail.com"
                )
        );
        people.add(
                new Person(
                        "Mariya",
                        LocalDate.of(1994, 3, 31),
                        Person.Gender.FEMALE,
                        "maria@gmail.com"
                )
        );

        printPeopleOlderThan(people, 18);
        System.out.println();
        printPeopleWithinAgeRange(people, 18, 21);
        System.out.println();
        printPeopleMatchingGender(people, Person.Gender.MALE);
        System.out.println();
        printPeopleOlderThanAndMatchingGender(
                people,
                18,
                Person.Gender.FEMALE
        );
        System.out.println();

        // Локален клас
        class PersonAgeRangeCriteria implements PersonCriteria {
            @Override
            public boolean isSatisfiedFor(Person person) {
                return person.getAge() >= 18 && person.getAge() < 22;
            }
        }
        printPeople(
                people,
                new PersonAgeRangeCriteria()
        );
        System.out.println();

        // Анонимен клас
        printPeople(
                people,
                new PersonCriteria() {
                    @Override
                    public boolean isSatisfiedFor(Person person) {
                        return person.getAge() >= 18 && person.getAge() < 22;
                    }
                }
        );
        System.out.println();

        // Ламбда функция
        printPeople(
                people,
                person -> person.getAge() >= 18 && person.getAge() < 22
        );
        System.out.println();

        printPeople(
                people,
                person ->
                        person.getAge() == 18 &&
                        person.getGender() == Person.Gender.MALE
        );
    }

    private static void printPeople(List<Person> people,
                                    PersonCriteria personCriteria) {
        for (var person : people) {
            if (personCriteria.isSatisfiedFor(person)) {
                person.print();
            }
        }
    }

    private static void printPeopleOlderThan(List<Person> people, int age) {
        for (var person : people) {
            if (person.getAge() >= age) {
                person.print();
            }
        }
    }

    private static void printPeopleWithinAgeRange(List<Person> people,
                                                  int low,
                                                  int high) {
        for (var person : people) {
            if (low <= person.getAge() && person.getAge() < high) {
                person.print();
            }
        }
    }

    static private void printPeopleMatchingGender(List<Person> people,
                                                  Person.Gender gender) {
        for (var person : people) {
            if (person.getGender() == gender) {
                person.print();
            }
        }
    }

    static private void printPeopleOlderThanAndMatchingGender(
            List<Person> people,
            int age,
            Person.Gender gender) {
        for (var person : people) {
            if (person.getAge() >= age && person.getGender() == gender) {
                person.print();
            }
        }
    }
}
