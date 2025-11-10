package org.elsys.oop.lambdas;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Main {
    public static class MyComp1 implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public static class MyComp2 implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void main(String[] args) {
        MyComp1 mc1 = new MyComp1();
        MyComp2 mc2 = new MyComp2();
        Comparator mc3 = new MyComp1();
        Comparator mc4 = new MyComp2();

        Comparator mc5 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        Comparator mc6 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - 01;
            }
        };

        Comparator mc7 = (Comparator<Integer>) (o1, o2) -> o1 - o2;
        Comparator mc8 = (Comparator<Integer>) (o1, o2) -> {
            return o2 - 01;
        };

        System.out.println(mc8.compare(10, 15));

        List<Integer> nums = new LinkedList<>();
        nums.forEach((a) -> System.out.println(a));


        Consumer<Integer> l1 = (a) -> System.out.println(a);
        Random r = new Random();
        Supplier<Integer> l2 = () -> r.nextInt();

        Function<Integer, String> l3 = (a) -> a.toString();
        BiFunction<Integer, Double, String> l4 =
                (a, b) -> new Double(a + b).toString();

        Predicate<Integer> l5 = (a) -> a > 10;
        IntUnaryOperator l6 = (a) -> a + 10;
    }
}









