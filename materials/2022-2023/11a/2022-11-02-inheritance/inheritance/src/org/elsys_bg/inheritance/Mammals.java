package org.elsys_bg.inheritance;

public abstract class Mammals extends Animal implements Walk{
    public Mammals(String name, int age, Color color) {
        super(name, age, color);
    }

    @Override
    public final void walk() {

    }
}
