package org.elsys.oop;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Fruit> products = new ArrayList<>();
//        products = new LinkedList<>();
//        products = new List<>();

        products.add(new Fruit(9.99f, 0.5f, "Krastavici"));
        products.add(new Fruit(4.99f, 0.25f, "Domati"));
        products.add(new Fruit(7.35f, 0.95f, "Portokali"));
        products.add(new Fruit(6.22f, 0.75f, "Portokali"));

//        for(int i=0; i<products.size(); i++) {
//            for(int j = i +1; j < products.size(); j++) {
//                Fruit left = products.get(i);
//                Fruit right = products.get(j);
//
//                if(left.price > right.price) {
//                    // ????
//                }
//            }
//        }

        System.out.println("Before sort:");
        for (Fruit prod : products) {
            System.out.println(prod);
        }

//        Collections.sort(products);
//        Collections.sort(products, new Comparator<Fruit>() {
//            @Override
//            public int compare(Fruit o1, Fruit o2) {
//                if(o1.weight > o2.weight) return 1;
//                if(o1.weight < o2.weight) return -1;
//
//                return 0;
//            }
//        });
        Collections.sort(products, new Fruit.CompareWeights());

        System.out.println("\nAfter sort:");
        for (Fruit prod : products) {
            System.out.println(prod);
        }

        Collections.sort(products, Collections.reverseOrder(new Fruit.CompareWeights()));

        System.out.println("\nAfter reverse:");
        for (Fruit prod : products) {
            System.out.println(prod);
        }
    }
}
