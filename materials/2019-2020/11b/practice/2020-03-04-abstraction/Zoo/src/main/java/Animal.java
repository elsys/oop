package main.java;

public abstract class Animal {
    private String name;

    public void sayName() {
        System.out.println("My name is " + this.name);
    }

    Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
