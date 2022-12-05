package org.elsys_bg.junit;

public class Calculator {
    int a;
    int b;

    Calculator() {
        a = 0;
        b = 0;
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public int minus(int a) {
        return -a;
    }


    public boolean isOdd(int number) {
        return number % 2 != 0;
    }

    public double divide(int a, int b) {
        if(b == 0) {
            throw new IllegalArgumentException("Can't divide by 0");
        }

        return a / b;
    }
}
