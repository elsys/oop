package org.elsys;

public class Bill implements Comparable<Bill> {

    private final int value;

    public Bill(int value) {
        this.value = value;
    }

    public Bill() {
        this.value = 1;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Bill o) {
        return this.value - o.value;
    }
}
