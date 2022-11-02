package org.elsys_bg.inheritance;

public class Bat extends Mammals implements Walk, Fly{
    public Bat(String name, int age, Color color) {
        super(name, age, color);
    }

    @Override
    public void makeSound() {

    }

    @Override
    public void fly() {

    }

    @Override
    public void walk() {

    }
}
