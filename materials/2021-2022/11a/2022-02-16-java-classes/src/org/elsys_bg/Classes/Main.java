package org.elsys_bg.Classes;

import org.elsys_bg.Bike.simple.Bike;

public class Main {

    public static void main(String[] args) {
        new Bike(2);
        Bike bike = new Bike(2);
        Bike bike2 = new Bike(1, 2, 3);
//        bike2 = bike;
        bike.setSpeed(2);
//        System.out.println(Bike.getCounter());

        bike.test(2, 3, 5, 6, 7);

        int[] arr = {1, 2, 3, 4};
        bike.test(arr);
        int var = 4;
        test(4);
        System.out.println(var);
        bike = test(bike);
        System.out.println(bike.getSpeed());
    }

    public static void test(int var) {
        var = 5;
        System.out.println(var);
    }

//    public static void test(Bike bike) {
//        bike.setSpeed(10);
//        bike = new Bike(2);
//        bike.setSpeed(5);
//    }

    public static Bike test(Bike bike) {
        bike.setSpeed(10);
        bike = new Bike(2);
        bike.setSpeed(5);

        return bike;
    }
}
