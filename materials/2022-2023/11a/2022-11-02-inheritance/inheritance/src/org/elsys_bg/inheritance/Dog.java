package org.elsys_bg.inheritance;

public class Dog extends Mammals {
    public Dog(String name, int age, Color color) {
        super(name, age, color);
    }

    @Override
    public void makeSound() {
        System.out.println("Bao");
    }

    public final int test() {
        System.out.println("I am final method");
        return 1;
    }
}
