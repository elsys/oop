package org.elsys.duzunov;

public class Employee extends Person {
    double salary;

    public Employee(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}
