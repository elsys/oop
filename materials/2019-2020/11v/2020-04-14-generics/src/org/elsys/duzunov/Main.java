package org.elsys.duzunov;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List list = new LinkedList();
        list.add(42);
        // нуждаем се от кастванe (Object -> int)
        int i = (int) list.iterator().next();
        System.out.println(i);

        List<Integer> integerList = new LinkedList<>();
        integerList.add(42);
        // не се нуждаем от кастване
        // (тук имаме автоматичен unboxing - Integer -> int)
        int integer = integerList.iterator().next();
        System.out.println(integer);

        Box<Integer> box = new Box<>();
        box.setValue(42);
        var value = box.getValue();
        System.out.println(value);

        Pair<Integer, String> pair1 = new Pair<>(1, "apple");
        Pair<Integer, String> pair2 = new Pair<>(2, "pear");
        // Пълен синтаксис за извикване на генерични методи
        boolean areEqual = Util.<Integer, String>areEqual(pair1, pair2);
        // Съкратен синтаксис (тук имаме type inference)
        areEqual = Util.areEqual(pair1, pair2);
        System.out.println(areEqual);

        Box<?> objectBox;
        Box<Integer> integerBox = new Box<>();
        integerBox.setValue(42);
        objectBox = integerBox;
        System.out.println(objectBox.getValue());
        Box<Double> doubleBox = new Box<>();
        doubleBox.setValue(42.);
        objectBox = doubleBox;
        System.out.println(objectBox.getValue());

        List<Integer> integers = Arrays.asList(1, 2, 3);
        printCollection(integers);
        List<String> strings = Arrays.asList("one", "two", "three");
        printCollection(strings);

        List<Long> longs = Arrays.asList(9000000000000000000L, 2L, 3L);
        System.out.println(sumNumbers(longs));

        ArrayList<Integer> integerArrayList = new ArrayList<>();
        addNumbers(integerArrayList);
        List<Number> numbers = new ArrayList<>();
        addNumbers(numbers);
        List<Object> objects = new ArrayList<>();
        addNumbers(objects);
    }

    // Неограничен wildcard (?) - означава "който и да е тип".
    // <?> е същото като <? extends Object>, защото "който и да е тип"
    // наследява Object.
    // Използва се, когато:
    // - можем да имплементираме исканата функционалност само чрез методите на
    // Object.
    // - при имплементиране на функционалността не се интересуваме от конкретния
    // подаден тип, а единствено от "wrapper" типа. Например, ако имаме List<?>
    // и искаме да напишем метод който проверява дали списък има повече от 100
    // елемента, то се интересуваме единствено от дължината на списъка (методът
    // size), не и от конкретния тип на елементите в списъка.
    private static void printCollection(Collection<?> c) {
        for (Object e : c) {
            System.out.println(e);
        }
    }

    // Ограничаване на wildcard отгоре. В примера с List<? extends Number>, ?
    // може да бъде Number или всеки друг тип, наследяващ Number.
    private static double sumNumbers(List<? extends Number> numbers) {
       double sum = 0;
       for (Number number : numbers) {
           sum += number.doubleValue();
       }
       return sum;
    }

    // Ограничаване на wildcard отдолу. В примера с List<? super Integer>, ?
    // може да бъде Integer или всеки друг тип, за който Integer е пряк/непряк
    // наследник. В случая това са типовете Integer, Number и Object.
    private static void addNumbers(List<? super Integer> list) {
        for (int i = 0; i < 10; ++i) {
            list.add(i);
        }
    }
}
