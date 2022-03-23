package org.elsys_bg.colections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Item> list = new ArrayList<>();
        Item i = new Item(1);
        Item i1 = new Item(3);
        Item i2 = new Item(9);
        Item i3 = new Item(4);
        Item i4 = new Item(6);
        list.add(i);
        list.add(i1);
        list.add(i2);
        list.add(i3);
        list.add(i4);

        print(list);

        ItemComparator comparator = new ItemComparator();
        list.sort(comparator);
        System.out.println("Sorted list:");
        print(list);

        System.out.println("Using comparable:");
        Collections.sort(list);
        print(list);

        Item i5 = new Item(3);

        System.out.println("Index of i1: " + list.indexOf(i1));
        System.out.println("Index of i5: " + list.indexOf(i5));
    }

    private static void print(List<Item> list) {
        Iterator<Item> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
