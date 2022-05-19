package org.elsys_bg.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Ivan", Person.Sex.MALE, 25);
        Person p2 = new Person("Petkan", Person.Sex.MALE, 39);
        Person p3 = new Person("Ivanka", Person.Sex.FEMALE, 19);
        Person p4 = new Person("Petkanka", Person.Sex.FEMALE, 26);

        List<Person> list = new ArrayList<>();

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        for (Person p : list) {
            if(Person.Sex.MALE.equals(p.getGender())) {
                System.out.println(p.getName());
            }
        }

        list.stream().forEach(p -> System.out.println(p.getName()));
        list.stream()
                .filter(p -> Person.Sex.MALE.equals(p.getGender()))
                .forEach(p -> System.out.println(p.getName()));

        int sum = 0;
        for (Person p : list) {
            sum += p.getAge();
        }
        double avg = sum / list.size();

        //IntStream, DoubleStream, LongStream
        list.stream()
                .mapToInt(Person::getAge)
                .average().getAsDouble();

        List<String> names = new ArrayList<>();
        for(Person p : list) {
            names.add(p.getName());
        }

        List<String> collect = list.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        Map<Person.Sex, List<Person>> map = new HashMap<>();
        for(Person p : list) {
            if(map.containsKey(p.getGender())) {
                List<Person> list1 = map.get(p.getGender());
                list1.add(p);
            } else {
                List<Person> persons = new ArrayList<>();
                persons.add(p);
                map.put(p.getGender(), persons);
            }
        }

        Map<Person.Sex, List<Person>> collect1 = list.stream()
                .collect(Collectors.groupingBy(p -> p.getGender()));

        //[a, b, c]
        String[] arr = {"a", "b", "c"};
        String result = "[";
        for(int i = 0; i< arr.length; i++) {
            if( i + 1 < arr.length) {
                result += arr[i] + ",";
            } else {
                result += arr[i] + "]";
            }
        }

        System.out.println(result);

        String result2 = Arrays.stream(arr).collect(Collectors.joining(",", "[", "]"));
        System.out.println(result2);


        //Optional
//        Optional<Person> person = Optional.empty();
//        person.get().getAge();

        //source, operations/iteration, reductor/colector

    }
}