package main.java;

public class FlyingFish extends Fish implements ICanSwim, ICanFly {
    FlyingFish(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("I am " + getName() +  "the flying fish and I am swimming");
    }

    @Override
    public void swim() {
        System.out.println("I am " + getName() +  "the flying fish and I am swimming");
    }
}
