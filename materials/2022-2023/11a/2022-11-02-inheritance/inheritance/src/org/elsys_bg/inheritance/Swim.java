package org.elsys_bg.inheritance;

public interface Swim {
    void swim();

    default void dive() {
        System.out.println("I am diving");
    }
}
