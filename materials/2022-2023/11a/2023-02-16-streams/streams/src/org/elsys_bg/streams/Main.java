package org.elsys_bg.streams;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Test", 10));
        persons.add(new Person("Test", 19));
        persons.add(new Person("Ivan", 15));
        persons.add(new Person("Pesho", 20));
        persons.add(new Person("Pesho2", 20));
        Optional<String> first = persons.stream()
                .filter(person -> person.getAge() > 18)
                .limit(2)
                .skip(1)
                .map(person -> person.getName())
                .filter(name -> name.length() > 10)
                .findFirst();
        String s = first.orElse("10");
//                .orElse("10");

        persons.stream().forEach(person -> System.out.println(person));

        List<Person> newList = new ArrayList<>();
        newList.addAll(persons);
        newList = new ArrayList<>(persons);

        System.out.println(persons.stream()
                .mapToInt(Person::getAge)
                .sum());

        persons.forEach(p -> p = new Person("", 12));
        persons.forEach(p -> System.out.println(p));

        List<String> collect = persons.stream()
                .map(p -> p.getName())
                .collect(Collectors.toList());

        Map<Integer, List<Person>> collect1 = persons.stream()
                .collect(Collectors.groupingBy(p -> p.getAge()));

        List<List<Person>> manyPersons = new ArrayList<>();
        manyPersons.add(persons);
        manyPersons.add(persons);
        manyPersons.add(persons);

        manyPersons.stream()
                .flatMap(list -> list.stream())
                .toList();


        test(Optional.empty());
//        test(Optional.of(null));
        test(Optional.of(new Person("Test", 19)));


    }

    public static void test(Optional<Person> person) {
        if (person.isPresent()) {
            person.get().getAge();
        }

//        person.ifPresent(person1 -> System.out.println(person1.getAge()));
        person.filter(person1 -> person1.getAge() > 18).ifPresent(person1 -> System.out.println(person1));
    }

    public static Optional<Person> create() {
        return Optional.ofNullable(null);
    }
}