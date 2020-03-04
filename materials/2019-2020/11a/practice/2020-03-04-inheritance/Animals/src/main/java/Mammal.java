package main.java;

public abstract class Mammal extends Animal{

    Mammal(){}

    Mammal(String name, int age){
        super(name, age);
    }

    public abstract String giveBirth();


}
