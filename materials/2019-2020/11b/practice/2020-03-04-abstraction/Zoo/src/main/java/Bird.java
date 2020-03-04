package main.java;

public abstract class Bird extends Animal{
    Bird(String name) {
        super(name);
    }

    void layEggs() {
        System.out.println("I am bird and I am laying eggs");
    }
}
