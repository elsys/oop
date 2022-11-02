package org.elsys_bg.inheritance;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Dog dog = new Dog("Krum", 17, Color.RED);
        Color red = Color.valueOf("RED");//Color.RED
        Color[] values = Color.values();
        Cat cat = new Cat("Pesho", 2, Color.GREEN);
        System.out.println(cat.getName());
        System.out.println(cat.name);
        Walk walk = cat;
        Mammals m = cat;
        Animal a = cat;
        walk.walk();
        a.makeSound();

        List<Fly> flyAniumals = new ArrayList<>();
        Fly fly = flyAniumals.get(0);
        fly.fly();

        //Animal animal = new Animal(); can't create instances of abstract classes
    }



}