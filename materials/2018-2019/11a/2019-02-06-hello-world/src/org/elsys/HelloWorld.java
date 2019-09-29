package org.elsys;

import java.util.Scanner;

public class HelloWorld {

    public static void main(String[] args) {
	    System.out.printf("Welcome to the Java world, Mr. %s!\n", args[0]);

	    int a = 5;

	    plusPlus(a);
	    System.out.println("Inside main(): " + a);

	    int[] integers = new int[4];
	    integers[0] = 5;

	    readIntegers(integers);

	    System.out.println("integers: " + toString(integers));
        System.out.println("  powers: " + toString(powers(integers)));
    }

    private static void plusPlus(int a) {
        a++;
        System.out.println("inside plusPlus(): " + a);
    }

    private static int[] powers(int[] integers) {
        int[] result = new int[integers.length];
        for (int i = 0; i < integers.length; i++) {
            result[i] = integers[i] * integers[i];
        }
        return result;
    }

    private static void readIntegers(int[] integers) {
//        java.util.Scanner scanner = new java.util.Scanner(System.in);
//        ^^ This way there's no need to import the class
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < integers.length; i++) {
            integers[i] = scanner.nextInt();
        }
    }

    public static String toString(int[] integers) {
        String result = "";
        for (int value : integers) {
            result += value + " ";
        }
        return result;
    }
}
