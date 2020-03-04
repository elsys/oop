package main.java;

public class FlyingFish extends Fish implements Fly{

    FlyingFish(){
        super();
    }

    @Override
    public String fly(){
        return "I'm Flying!";
    }
}
