package org.elsys.generics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Main {

    /*
    T - type
    K - key
    V - value
    E - element
    N - number
     */
    public static class Test <K, V> {
        private K test;
        private V value;
        public Test(K test) {
            this.test = test;
        }

        public K getTest() {
            return test;
        }
    }

//    public class Test2 {
//        private Integer test;
//        public Test2(Integer test) {
//            this.test = test;
//        }
//
//        public Integer getTest() {
//            return test;
//        }
//    }
//
//    public class Test3 {
//        private Double test;
//        public Test3(Double test) {
//            this.test = test;
//        }
//
//        public Double getTest() {
//            return test;
//        }
//    }
    public static void main(String[] args) {

        Main main = new Main();
//        Test<String> test = new Test("test");
//        Test<Integer> test2 = new Test(232);
//        Test<Integer> test21 = new Test(232);
//        Test<Double> test3 = new Test(23.56);

//        var result = (Integer) test.getTest() + (Integer) test21.getTest();

//        var result2 = test.getTest() + test21.getTest();

//        System.out.println(result2);

//        Test2 test2 = new Test2(23);

        System.out.println("Hello world!");
        List<String> list = new ArrayList<>();

        add(23, 12);
        add(12l, 12l);
        add(23.5d, 53.5d);

        List<Integer> ints = new ArrayList<>();
        ints.add(2);
        ints.add(3);

        List<Double> doubles = new ArrayList<>();
        doubles.add(12.4d);
        doubles.add(15.4d);

        print(ints);
        print(doubles);

        List<Number> numbers = new ArrayList<>();
        numbers.add(12);
        numbers.add(23.5);

        print(numbers);

        print(12.5d);

    }

    public static void print(Number n) {
        System.out.println(n.doubleValue());
    }

    public static void m2(Test<? extends  Number, ? extends CharSequence> test) {

    }

    public static void print(List<? extends Number> numbers) {
        for(Number n : numbers) {
            System.out.println(n.doubleValue());
        }
    }

    public static  <T extends Number> double add(T i1, T i2) {
        return i1.doubleValue() + i2.doubleValue();
    }

    public static <T, U> void sds(T t, U u) {

    }

    public void test() {
//        Test2 test = new Test2(23);
    }
}