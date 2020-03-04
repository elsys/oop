package main.java;

public class Whale extends Mammal implements Swim {
    public Whale(){
        super();
    }

    public String giveBirth(){
        return "Giving Birth!";
    }
    @Override
    public String swim(){
        return "I'm Swimming!";
    }

}
