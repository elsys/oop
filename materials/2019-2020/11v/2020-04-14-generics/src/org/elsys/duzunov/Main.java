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
    }

    private static void printCollection(Collection<?> c) {
        for (Object e : c) {
            System.out.println(e);
        }
    }
}
