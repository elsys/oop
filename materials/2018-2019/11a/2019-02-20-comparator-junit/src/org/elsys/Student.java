package org.elsys;

import java.util.Objects;

public class Student {

    private String name;

    private String clazz;

    private double averageGrade;

    public Student(String name, String clazz, double averageGrade) {
        this.name = name;
        this.clazz = clazz;
        this.averageGrade = averageGrade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.averageGrade, averageGrade) == 0 &&
                Objects.equals(name, student.name) &&
                Objects.equals(clazz, student.clazz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, clazz, averageGrade);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }
}
