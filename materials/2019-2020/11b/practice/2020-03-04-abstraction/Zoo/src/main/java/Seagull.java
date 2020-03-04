package main.java;

public class Seagull extends Bird implements ICanWalk, ICanSwim, ICanFly {
    Seagull(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("I am " + getName() +  "the seagull and I am flying");
    }

    @Override
    public void swim() {
        System.out.println("I am " + getName() +  "the seagull and I am swimming");
    }

    @Override
    public void walk() {
        System.out.println("I am " + getName() +  "the seagull and I am walking");
    }
}
