package org.elsys.duzunov;

import java.util.ArrayList;

public class Student implements Comparable<Student> {
    private String name;
    private int number;
    private int grade;
    private ArrayList<Double> grades;

    Student(String name, int number, int grade) {
        this.name = name;
        this.number = number;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getGrade() {
        return grade;
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }

    @Override
    public int compareTo(Student o) {
        return getName().compareTo(o.getName());
    }
}
