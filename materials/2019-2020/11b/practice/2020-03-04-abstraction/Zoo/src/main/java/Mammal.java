package main.java;

public abstract class Mammal extends Animal {
    Mammal(String name) {
        super(name);
    }

    public void giveBirth() {
        System.out.println("I am mammal and I am giving birth");
    }

}
