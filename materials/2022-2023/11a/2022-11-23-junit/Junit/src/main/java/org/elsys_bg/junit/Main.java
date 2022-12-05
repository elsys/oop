package org.elsys_bg.junit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Calculator c = new Calculator();

        int result = c.sum(1, 2);

        System.out.println(result == 3);
    }
}