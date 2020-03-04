package main.java;

public class Whale extends Mammal implements ICanSwim{
    public Whale(String name) {
        super(name);
    }


    @Override
    public void swim() {
        System.out.println("I am " + getName() +  " the whale and I am swimming");
    }
}
