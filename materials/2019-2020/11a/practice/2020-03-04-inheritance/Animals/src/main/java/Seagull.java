package main.java;

public class Seagull extends Bird implements Fly{
    public Seagull(){
        super();
    }

    public String layEggs(){
        return "Laying Eggs!";
    }
    public String fly(){
        return "I'm Flying!";
    }

}
