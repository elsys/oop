package main.java;

public class Salmon extends Fish implements ICanSwim {

    Salmon(String name) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.println("I am " + getName() +  "the salmon and I am swimming");
    }
}
