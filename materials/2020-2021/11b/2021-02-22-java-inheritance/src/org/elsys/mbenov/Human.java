package org.elsys.mbenov;

public abstract class Human {
    String name;
    int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean canTravel() {
        System.out.println("Human can travel?");
        return false;
    };

    public abstract boolean canPerformGenocide();
}
