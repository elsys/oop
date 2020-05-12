package org.elsys.duzunov;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // Имаме списък от низове, който искаме да сортираме по дължината на
        // низовете във възходящ ред. За целта ще използваме стандартния метод
        // sort заедно с подходящ компаратор.
        List<String> strings = new ArrayList<>(
                Arrays.asList("a1", "vivacom", "telenor", "mtel")
        );

        // Локален клас - можем да използваме локален клас за дефиницията на
        // компаратора. Локалните класове са класове дефинирани в даден блок.
        // Могат да бъдат дефинирани във всеки блок - например блок на if,
        // for, while или в блок на произволен метод). Използват се най-често в
        // тялото на методи, когато дефинираната от тях функционалност се отнася
        // конкретно за методите, в които са дефинирани. Тоест локалните класове
        // са най-често помощни класове за дадени методи.
        class StringLengthComparator implements Comparator<String> {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        }
        strings.sort(new StringLengthComparator());

        // Анонимен клас. Локалният клас от горния пример се използва само на
        // едно място - за сортирането на списъка от низове. Тогава се
        // обезсмисля задаването на име на този клас. Затова можем да използваме
        // анонимен клас. Анонимният клас е клас, който няма зададено име и
        // наследява даден клас или имплементира даден интерфейс (в случая
        // съдаваме анонимен клас, който имплементира интерфейса
        // Comparator<String>). С дефиницията на анонимния клас върви и
        // ключовата дума new, с която създаваме обкет от дефинирания анонимен
        // клас. Използваме анонимните класове, когато искаме да имплементираме
        // конкретна функционалност, която ще се използва еднократно в
        // програмата ни и е достатъчно кратка, че да бъде четим кода ни.
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        // Ламбда функция (анонимна функция). Чрез анонимния клас си спестихме
        // писане на код и направихме кода ни по-четим, но в случая можем да
        // напишем сортирането още по-четимо, използвайки ламбда функция.
        // Когато анонимен клас имплементира интерфейс, който има точно един
        // абстрактен метод (метод без дефиниция), можем вместо анонимния клас
        // да използваме ламбда функция, която задава дефиницията на точно този
        // абстрактен метод (в нашия случай това е мотодът compare от интерфейса
        // Comparable<String>). Такива интерфейси се наричат функционални
        // (functional interfaces). Където се очаква да бъде подаден обект от
        // клас, имплементиращ функционален интерфейс, можем да подадем ламбда
        // функция, имплементираща абстрактния метод от функционалния интерфейс.
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

        int foo = 42;
        // Локален клас
        class PersonAgeRangeCriteria implements PersonCriteria {
            @Override
            public boolean isSatisfiedFor(Person person) {
                System.out.println(foo);
                return person.getAge() >= 18 && person.getAge() < 22;
            }
        }
        // foo++; // компилационна грешка на ред 130 - не можем да използваме
        // външна променлива в локалния клас, ако тя се променя в контекста, в
        // който е дефиниран локалния клас. Тази рестрикция се налага от
        // компилатора, за да може поведението на метода от локалния клас да
        // бъде едно и също независимо от контекста, в който се използва. По
        // този начин избягваме непредвидимо поведение на програмата ни. Същата
        // рестрикция важи и при достъпа на външни променливи в анонимни класове
        // и ламбда функции.

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
                (PersonCriteria) person ->
                        person.getAge() >= 18 && person.getAge() < 22
        );
        System.out.println();

        printPeople(
                people,
                (Predicate<Person>) person ->
                        person.getAge() == 18 &&
                        person.getGender() == Person.Gender.MALE
        );
        System.out.println();

        processPeople(
                people,
                person ->
                        person.getGender() == Person.Gender.FEMALE &&
                                person.getAge() == 17,
                person -> person.print()
        );
        System.out.println();

        processPeople(
                people,
                person ->
                        person.getGender() == Person.Gender.FEMALE &&
                                person.getAge() == 17,
                person -> sendMessage("You're awesome!", person)
        );
        System.out.println();

        processPeople(
                people,
                person ->
                        person.getGender() == Person.Gender.FEMALE &&
                                person.getAge() == 17,
                person -> System.out.println(person.getEmailAddress())
        );
        System.out.println();

        processPeople(
                people,
                person ->
                        person.getGender() == Person.Gender.FEMALE &&
                                person.getAge() == 17,
                person -> person.getEmailAddress(),
                email -> System.out.println(email)
        );
        System.out.println();

        processElements(
                people,
                person ->
                        person.getGender() == Person.Gender.MALE &&
                                person.getAge() == 18,
                person -> person.getEmailAddress(),
                email -> System.out.println(email)
        );
        System.out.println();

        people
                .stream()
                .filter(
                        person ->
                                person.getGender() == Person.Gender.FEMALE &&
                                        person.getAge() == 17
                )
                .map(person -> person.getEmailAddress())
                .forEach(email -> System.out.println(email));
    }

    private static void sendMessage(String message, Person person) {
        System.out.println(
                String.format(
                        "Message \"%s\" was successfully sent to %s.",
                        message,
                        person.getName()
                )
        );
    }

    private static <T, R> Collection<R> collectElements(Iterable<T> elements,
                                                        Predicate<T> tester,
                                                        Function<T, R> mapper) {
        ArrayList<R> arrayList = new ArrayList<>();
        for (var element : elements) {
            if (tester.test(element)) {
                arrayList.add(mapper.apply(element));
            }
        }
        return arrayList;
    }

    private static <T, R> void processElements(Iterable<T> elements,
                                               Predicate<T> tester,
                                               Function<T, R> mapper,
                                               Consumer<R> block) {
        for (var element : elements) {
            if (tester.test(element)) {
                block.accept(mapper.apply(element));
            }
        }
    }

    private static void processPeople(List<Person> people,
                                      Predicate<Person> tester,
                                      Function<Person, String> mapper,
                                      Consumer<String> block) {
        for (var person : people) {
            if (tester.test(person)) {
                block.accept(mapper.apply(person));
            }
        }
    }

    private static void processPeople(List<Person> people,
                                      Predicate<Person> tester,
                                      Consumer<Person> block) {
        for (var person : people) {
            if (tester.test(person)) {
                block.accept(person);
            }
        }
    }

    private static void sendMessageToPeople(List<Person> people,
                                            Predicate<Person> tester) {
        for (var person : people) {
            if (tester.test(person)) {
                sendMessage("You're awesome!", person);
            }
        }
    }

    private static void printPeople(List<Person> people,
                                    Predicate<Person> tester) {
        for (var person : people) {
            if (tester.test(person)) {
                person.print();
            }
        }
    }

    private static void printPeople(List<Person> people,
                                    PersonCriteria personCriteria) {
        for (var person : people) {
            if (personCriteria.isSatisfiedFor(person)) {
                person.print();
            }
        }
    }

    // Функционален интерфейс е интерфейс, който има точно един абстрактен
    // метод (метод без дефиниция) и всички други методи са default или static
    // (тоест имат дефиниция).
    @FunctionalInterface
    private interface PersonCriteria {
        boolean isSatisfiedFor(Person person);

        default void foo() {
            System.out.println("foo");
        }

        static void bar() {
            System.out.println("bar");
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
            Person.Gender gender
    ) {
        for (var person : people) {
            if (person.getAge() >= age && person.getGender() == gender) {
                person.print();
            }
        }
    }
}
