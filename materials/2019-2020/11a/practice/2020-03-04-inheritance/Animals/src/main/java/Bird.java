package main.java;

public abstract class Bird extends Animal implements Walk, Swim{
    Bird(){}

    Bird(String name, int age){
        super(name, age);
    }

    public abstract String layEggs();
    @Override
    public String swim(){
        return "I'm Swimming!";
    }
    @Override
    public String walk(){
        return "I'm Walking!";
    }
}
