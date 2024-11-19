package org.elsys.oop.packages.example;

public class DrivingLicense {
    public int number;
    public Person owner;

    public int getNumber() {
        return number;
    }

    public Person getOwner() {
        return owner;
    }

    public DrivingLicense(int number, Person owner) {
        this.number = number;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "DrivingLicense{" +
                "number=" + number +
                ", owner=" + owner +
                '}';
    }
}
