package main.java;

public class Cat extends Mammal implements Swim, Walk {
    Cat(){
        super();
    }

    public String giveBirth(){
        return "Giving Birth!";
    }
    @Override
    public String swim(){
        return "I'm Swimming!";
    }
    @Override
    public String walk(){
        return "I'm Walking!";
    }
}
