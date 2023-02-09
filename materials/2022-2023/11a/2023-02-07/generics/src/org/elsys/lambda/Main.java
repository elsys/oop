package org.elsys.lambda;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Validator validator = new Validator() {
            @Override
            public boolean test(String value) {
                return value.isEmpty();
            }
        };

        IntegerComparator comp = new IntegerComparator(){
            public int test = 2;
            public void test() {
                System.out.println(123);
            }
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1*super.compare(o1, o2);
            }
        };

        IntegerComparator comp2 = new IntegerComparator();

        comp.compare(2, 4);

        List<Integer> list = new ArrayList<>();
        Collections.sort(list, new IntegerComparator());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
    }
}
