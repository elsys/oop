package org.elsys.duzunov;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List list = new LinkedList();
        list.add(42);
        int i = (int) list.iterator().next(); // explicit type cast
        System.out.println(i);

        List<Integer> integerList = new LinkedList<>();
        integerList.add(42);
        int integer = integerList.iterator().next(); // no explicit cast needed
        System.out.println(integer);

        Box<Integer> integerBox = new Box<>();
        integerBox.setValue(42);
        System.out.println(integerBox.getValue());

        Pair<Integer, String> p1 = new Pair<>(1, "apple");
        Pair<Integer, String> p2 = new Pair<>(2, "pear");
        // Full syntax
        boolean areEqual = Util.<Integer, String>areEqual(p1, p2);
        // Short syntax
        areEqual = Util.areEqual(p1, p2);
        System.out.println(areEqual);

        List<Integer> integers = Arrays.asList(1, 2, 3);
        printCollection(integers);
    }

    private static void printCollection(Collection<?> c) {
        for (Object e : c) {
            System.out.println(e);
        }
    }
}
