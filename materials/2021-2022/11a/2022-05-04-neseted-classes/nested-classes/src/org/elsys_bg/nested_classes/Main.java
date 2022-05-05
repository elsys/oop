package org.elsys_bg.nested_classes;

import java.util.*;

public class Main {
    private static String replaceWith = "a";
    private static String replace = "b";

    public static void main(String[] args) {
        OuterClass oc = new OuterClass();
        OuterClass.NestedClass nc = oc.new NestedClass();
        nc.printValue();

        OuterClass.StaticNestedClass.printStaticValue();

        DataStructure ds = new DataStructure();
        ds.printEven();

        someMetod("bqwtqeb", "c");

        //anonymous class
        AnonymousInterface ai = new AnonymousInterface() {
            @Override
            public void sayHello() {
                System.out.println("Hello");
            }
        };

        List<Integer> list = new ArrayList<>();
        list.sort(new Comparator<Integer>() {
            private int value = 2;
            private void ranodom() {

            }
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

        Set<Integer> set = new Set<Integer>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Integer> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Integer integer) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Integer> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        }
    }

    public static void someMetod(String value, String value2) {
        String replaceWith2 = value2;

        //can access only final objects
        class Replacer {
            public String replace() {
//                replaceWith2 = "d";
                return value.replace(replace, replaceWith2);
            }
        }

        Replacer replacer = new Replacer();
        String replace1 = replacer.replace();
        System.out.println(replace1);


    }
}