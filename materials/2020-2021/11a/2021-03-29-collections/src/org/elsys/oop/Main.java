package org.elsys.oop;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Appliance> products = new ArrayList<>();
//        products = new LinkedList<>();
//        products = new List<>() {
//            @Override
//            public int size() {
//                return 0;
//            }
//        };

        products.add(new Appliance("Samsung", 1500, 5));
        products.add(new Appliance("LG", 1500, 50));
        products.add(new Appliance("LG", 22000, 100));
        products.add(new Appliance("Apple", 150000, 25));

        System.out.println("Beginning:");
        for (Appliance prod : products) {
            System.out.println(prod);
        }

//        products.sort
        Collections.sort(products);

        System.out.println("\nAfter sort:");
        for (Appliance prod : products) {
            System.out.println(prod);
        }

//        products.sort((o1, o2) -> o1.power - o2.power);
//        products.sort(new Comparator<Appliance>() {
//            @Override
//            public int compare(Appliance o1, Appliance o2) {
//                return o1.power - o2.power;
//            }
//        });
        //products.sort(new Appliance.ComparePower());

        //products.sort(Collections.reverseOrder(new Appliance.ComparePower()));
        products.sort(new Appliance.ComparePower().reversed());
        //Collections.sort(products, new Appliance.ComparePower().reversed());

        System.out.println("\nAfter comparator:");
        for (Appliance prod : products) {
            System.out.println(prod);
        }
    }
}
