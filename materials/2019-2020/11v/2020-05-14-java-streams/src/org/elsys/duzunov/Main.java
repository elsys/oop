package org.elsys.duzunov;

import com.sun.jdi.event.StepEvent;

import java.time.LocalDate;
import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Създаване на потоци (инициализиращи операции)

        // Празен поток
        Stream<Integer> emptyIntegerStream = Stream.empty();
        print(emptyIntegerStream);

        // Поток от краен брой елементи
        Stream<Integer> someIntegers = Stream.of(42, 5, 33, 21, 10);
        print(someIntegers);

        // Поток от елементите на дадена колекция
        List<Integer> integerArrayList = List.of(1, 2, 42, 33);
        Stream<Integer> integerStreamFromList = integerArrayList.stream();
        print(integerStreamFromList);

        // Поток от елементите на масив
        IntStream intStreamFromArray = Arrays.stream(new int[] { 1, 2, 42 });
        print(intStreamFromArray);

        // Безкрайни потоци от случайни числа
        // double числа в интервала [0, 1)
        DoubleStream randomDoubles = new Random().doubles()
                .limit(10);
        print(randomDoubles);
        // int числа
        IntStream randomInts = new Random().ints()
                .limit(10);
        print(randomInts);
        // long числа
        LongStream randomLongs = new Random().longs()
                .limit(10);
        print(randomLongs);

        // Създаване на безкраен поток чрез итерация
        Stream<Integer> powersOf2 = Stream.iterate(1, Main::multiplyBy2);
        // 1, multiplyBy2(1), multiplyBy2(multiplyBy2(1)),
        // multiplyBy2(multiplyBy2(multiplyBy2(1))), ...
        Stream<Integer> powersOf2WithLambda = Stream.iterate(1, x -> 2 * x)
                .limit(5);
        // 1, 2 * 1, 2 * (2 * 1), 2 * (2 * (2 * 1)), ...
        print(powersOf2WithLambda);

        // Създаване на краен поток чрез итерация
        Stream<Integer> evensLessThan10 =
                Stream.iterate(0, x -> x < 10, x -> 2 + x);
        print(evensLessThan10); // 0, 2, 4, 6, 8

        // Създаване на безкраен поток от стойности
        // (чрез функционалния интерфейс Supplier<T>)
        Stream<Integer> ones = Stream.generate(() -> 1) // 1, 1, 1, ..., 1, ...
                .limit(3);
        print(ones);

        Stream<Integer> onesWithIterate =
                Stream.iterate(1, UnaryOperator.identity())
                        .limit(3);
        print(onesWithIterate);

        // Конкатенация на потоци
        Stream<String> stream1 = Stream.of("one", "two");
        Stream<String> stream2 = Stream.of("two", "three", "four");
        Stream<String> concatenation = Stream.concat(stream1, stream2);
        print(concatenation); // "one", "two", "two", "three", "four"

        // Обработката на потоци типично се организира като pipeline (конвейер):
        // - потокът се създава с инициализираща операция,
        // - поредица от междинни операции обработват потока, като резултатът от
        // всяка става вход за следващата във веригата
        // - накрая терминираща операция продуцира резултат или страничен ефект
        // и приключва потока

        // Операции върху потоци (функции от по-висок ред):
        // - междинни - връщат Stream обект като резултат
        // - терминиращи - връщат обект, различен от Stream,
        // или не връщат резултат

        List<Person> personList = new ArrayList<>();
        personList.add(
                new Person(
                        "Ivan",
                        LocalDate.of(2001, 12, 20),
                        Person.Gender.MALE,
                        "ivan@gmail.com"
                )
        );
        personList.add(
                new Person(
                        "Iliyan",
                        LocalDate.of(1980, 12, 1),
                        Person.Gender.MALE,
                        "iliyan@gmail.com"
                )
        );
        personList.add(
                new Person(
                        "Yordan",
                        LocalDate.of(1998, 12, 20),
                        Person.Gender.MALE,
                        "yordan@gmail.com"
                )
        );
        personList.add(
                new Person(
                        "Mariya",
                        LocalDate.of(1994, 3, 31),
                        Person.Gender.FEMALE,
                        "maria@gmail.com"
                )
        );

        // Междинни операции
        // Филтриращи операции
        Stream<Person> adults = personList.stream()
                .filter(person -> person.getAge() >= 18);
        print(adults.map(Person::getName));

        Stream<Person> firstTwoPeople = personList.stream().limit(2);
        print(firstTwoPeople.map(Person::getName));

        Stream<Person> distinctPeople = personList.stream().distinct();
        print(distinctPeople.map(Person::getName));

        Stream<Person> peopleWithoutFirst = personList.stream().skip(1);
        print(peopleWithoutFirst.map(Person::getName));

        Stream<Person> peopleWithIInitial = personList.stream()
                .takeWhile(person -> person.getName().startsWith("I"));
        print(peopleWithIInitial.map(Person::getName));

        Stream<Person> peopleWithoutIInitial = personList.stream()
                .dropWhile(person -> person.getName().startsWith("I"));
        print(peopleWithoutIInitial.map(Person::getName));

        // Трансформиращи (mapping) операции
        Stream<String> personNames = personList.stream()
                .map(Person::getName);
        IntStream personAges = personList.stream()
                .mapToInt(Person::getAge);

        // Сортиращи операции
        // спрямо естествената наредба (natural ordering)
        Stream<Person> sortedPeople = personList.stream()
                .sorted();

        // спрямо компаратор
        Stream<Person> sortedPeopleByAge = personList.stream()
                .sorted(Comparator.comparingInt(Person::getAge));

        // Терминиращи операции
//        personList.stream().forEach(Person::print);

        OptionalInt maybeAgeSum = personList.stream()
                .mapToInt(Person::getAge)
                .reduce((currentAgeSum, age) -> currentAgeSum + age);

        maybeAgeSum = personList.stream()
                .mapToInt(Person::getAge)
                .reduce(Integer::sum);

        int ageSum = personList.stream()
                .mapToInt(Person::getAge)
                .reduce(0, Integer::sum);

        ageSum = personList.stream()
                .reduce(
                        0, // начална стойност
                        (currentAgeSum, person) -> currentAgeSum + person.getAge(), // accumulator
                        (left, right) -> left + right // combiner - за комбиниране на резултатите от паралелни изчисления
                );

        // специални случаи на reduce:
        ageSum = personList.stream()
                .mapToInt(Person::getAge)
                .sum();

        OptionalDouble averageAge = personList.stream()
                .mapToInt(Person::getAge)
                .average();

        OptionalInt minAge = personList.stream()
                .mapToInt(Person::getAge)
                .min();

        OptionalInt maxAge = personList.stream()
                .mapToInt(Person::getAge)
                .max();

        // collect (mutable reduce)
        List<Integer> randomIntegers = new Random().ints()
                .limit(10)
                .collect(
                        ArrayList::new, // supplier
                        ArrayList::add, // accumulator
                        ArrayList::addAll // combiner
                );

        List<Integer> list = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toList());
//        System.out.println(list); // [1, 2, 3, 4, 5]
    }

    private static int multiplyBy2(int n) {
        return 2 * n;
    }

    private static <T> void print(Stream<T> stream) {
        stream.forEach(element -> System.out.print(element + ", "));
        System.out.println();
    }

    private static void print(IntStream stream) {
        stream.forEach(element -> System.out.print(element + ", "));
        System.out.println();
    }

    private static void print(DoubleStream stream) {
        stream.forEach(element -> System.out.print(element + ", "));
        System.out.println();
    }

    private static void print(LongStream stream) {
        stream.forEach(element -> System.out.print(element + ", "));
        System.out.println();
    }
}
