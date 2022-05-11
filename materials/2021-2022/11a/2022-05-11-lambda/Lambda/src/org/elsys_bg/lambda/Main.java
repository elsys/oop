package org.elsys_bg.lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        Person p1 = new Person("Gosho", Person.SEX.MALE, LocalDate.parse("1999-05-12")
                , "gosho@gmail.com");
        Person p2 = new Person("Pesho", Person.SEX.MALE, LocalDate.parse("2004-01-18"),
                "pesho@gmail.com");
        Person p3 = new Person("Nikolinka", Person.SEX.FEMALE, LocalDate.parse("2006-05-11")
                , "nikolinka@gmail.com");

        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
//        printPersonsOlderThan(persons, 15);
//        printPersonsInAgeRange(persons, 18, 25);
        AgeRangePersonFilter filter = new AgeRangePersonFilter();
//        printPersonsByCriteria(persons, filter);
//        printPersonsByCriteria(persons, new PersonFilter() {
//            @Override
//            public boolean test(Person p) {
//                return p.getAge() > 18 && p.getAge() < 25
//                        && p.getGender().equals(Person.SEX.MALE);
//            }
//        });

        //Functional interfaces - contains only one method
        //(Integer a, String b, Double c) - describe parameters - no need for braces when we have only one parameter
        // ->
        //body of the method
        // - one expression or no result is returned
//        printPersonsByCriteria(persons, p ->
//                p.getAge() > 18 && p.getAge() < 25 && p.getGender().equals(Person.SEX.MALE));
//
//
//        printPersonsByCriteria(persons, p -> {
//            int minAge = 18;
//            int maxAge = 25;
//            return p.getAge() > minAge && p.getAge() < maxAge
//                    && p.getGender().equals(Person.SEX.MALE);
//        });

//        printPersonsWithPredicate(persons, p ->
//                p.getAge() > 18 && p.getAge() < 25 && p.getGender().equals(Person.SEX.MALE));

//        processPersons(persons,
//                p -> p.getAge() > 18 && p.getAge() < 25 && p.getGender().equals(Person.SEX.MALE),
//                p -> System.out.println(p));

//        processPersons(persons,
//                p -> p.getAge() > 18 && p.getAge() < 25 && p.getGender().equals(Person.SEX.MALE),
//                p -> p.getEmail(),
//                p -> System.out.println(p));

//        processElements(persons,
//                p -> p.getAge() > 18 && p.getAge() < 25 && p.getGender().equals(Person.SEX.MALE),
//                p -> p.getEmail(),
//                p -> System.out.println(p));

        Calculator calculator = new Calculator();
        BinaryOperator<Integer> add = (a, b) -> a + b;
        int result = calculator.binaryOperation(2, 3, add);
        BinaryOperator<Integer> sub = (a, b) -> a - b;
        int result2 = calculator.binaryOperation(2, 3, sub);
        System.out.println(result);
        System.out.println(result2);

    }

    private static void printPersonsInAgeRange(List<Person> persons, int min, int max) {
        for (Person p : persons) {
            if (p.getAge() >= min && p.getAge() <= max) {
                System.out.println(p);
            }
        }
    }

    public static void printPersonsOlderThan(List<Person> persons, int age) {
        for (Person p : persons) {
            if (p.getAge() >= age) {
                System.out.println(p);
            }
        }
    }

    private static void printPersonsByCriteria(List<Person> persons, PersonFilter filter) {
        for (Person p : persons) {
            if (filter.test(p)) {
                System.out.println(p);
            }
        }
    }

    private static void printPersonsWithPredicate(List<Person> persons, Predicate<Person> filter) {
        for (Person p : persons) {
            if (filter.test(p)) {
                System.out.println(p);
            }
        }
    }

    private static void processPersons(List<Person> persons, Predicate<Person> filter, Consumer<Person> action) {
        for (Person p : persons) {
            if (filter.test(p)) {
                action.accept(p);
            }
        }
    }

    private static void processPersons(List<Person> persons,
                                       Predicate<Person> filter,
                                       Function<Person, String> mapper,
                                       Consumer<String> action) {
        for (Person p : persons) {
            if (filter.test(p)) {
                String data = mapper.apply(p);
                action.accept(data);
            }
        }
    }

    private static <T, U> void processElements(Iterable<T> elements,
                                          Predicate<T> filter,
                                          Function<T, U> mapper,
                                          Consumer<U> action) {
        for(T element : elements) {
            if(filter.test(element)) {
                U data = mapper.apply(element);
                action.accept(data);
            }
        }
    }


}