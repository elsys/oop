package org.elsys_bg.generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List list = new ArrayList<>();
//        list.add(new Integer());
//        list.add(new String());
        BoxType boxType = new BoxType();//uses Object as type
        BoxType boxType1 = new BoxType<String>();
        //BoxType<String> boxType2 = new BoxType<>(2); - error expects String but recives integer
//        BoxType<int> boxType2 = new BoxType<int>(); - error only complex types for genrics

        Pair<String, String> pair = new MyPair<>("A", "value");
        Pair<String, String> pair1 = new MyPair<>("B", "value");

        MyPair<String, String> pair3 = new MyPair<>("A", "value");
        MyPair<String, String> pair4 = new MyPair<>("B", "value");

        MyPair<Double, List<String>> pair2 = new MyPair<>();
        PredefinedPair predefinedPair = new PredefinedPair();

        print(predefinedPair);
        print(pair);
//        print("Test");

        getBigger(pair3, pair4);

        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);

        List<Double> l2 = new ArrayList<>();
        l2.add(1.1);
        l2.add(2.2);
        l2.add(3.3);

        double v = addList(l1);
        System.out.println(v);
        double v1 = addList(l2);
        System.out.println(v1);
        //Integer is a Number
        //List<Integer> is not List<Number>

        List<Number> l3 = new ArrayList<>();
        addNumber(l3);
    }

    public static <T> T retrunIt(T t) {
        return t;
    }

//    public static <T> void print(T t) {
//        System.out.println(t.toString());
//    }

    public static <T extends Pair> void print(T t) {
        System.out.println(t.getKey());
    }

    public static <T extends Comparable> T getBigger(T t1, T t2) {
        if(t1.compareTo(t2) > 0) {
            return t1;
        } else {
            return t2;
        }
    }

    public static double addList(List<? extends Number> list) {
        double sum = 0;
        for(Number t : list) {
            sum += t.doubleValue();
        }

        return sum;
    }

    public static void addNumber(List<? super Integer> list) {
        for(int i = 0; i< 10; i++) {
            list.add(i);
        }
    }
}