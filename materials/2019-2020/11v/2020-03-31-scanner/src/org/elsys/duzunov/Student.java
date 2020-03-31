package org.elsys.duzunov;

public class Student {
    private String name;
    private int number;
    private double averageMark;

    public Student(String name, int number, double averageMark) {
        this.name = name;
        this.number = number;
        this.averageMark = averageMark;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public String toString() {
        return getName() + ", " + getNumber() + ", " + getAverageMark();
    }
}
