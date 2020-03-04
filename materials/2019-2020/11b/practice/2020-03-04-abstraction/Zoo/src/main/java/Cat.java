package main.java;

public class Cat extends Mammal implements ICanWalk, ICanSwim {

    Cat(String name) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.println("I am " + getName() +  "the cat and I am swimming");
    }

    @Override
    public void walk() {
        System.out.println("I am " + getName() +  "the cat and I am walking");
    }
}
