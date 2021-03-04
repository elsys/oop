package org.elsys.mbenov;

public class Citizen extends Human implements ICommunist {
    public Citizen(String name, int age) {
        super(name, age);
    }

    @Override
    public boolean canPerformGenocide() {
        return false;
    }

    @Override
    public void vote() {
        System.out.println(name + " I voted with 1 vote");
    }
}
