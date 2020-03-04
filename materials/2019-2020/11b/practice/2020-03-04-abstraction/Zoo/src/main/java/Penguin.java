package main.java;

public class Penguin extends Bird implements ICanSwim, ICanWalk {
    Penguin(String name) {
        super(name);
    }
    @Override
    public void swim() {
        System.out.println("I am " + getName() +  "the penguin and I am swimming");
    }

    @Override
    public void walk() {
        System.out.println("I am " + getName() +  "the penguin and I am walking");
    }
}
