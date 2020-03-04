package main.java;

public abstract class Fish extends Animal implements Swim{
    Fish(){}

    Fish(String name, int age){
        super(name, age);
    }

    @Override
    public String swim(){
        return "I'm Swimming!";
    }
}
