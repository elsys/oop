package org.elsys.mbenov;

public class Ruler extends Human implements ICommunist {
    public Ruler(String name, int age) {
        super(name, age);
    }

    @Override
    public boolean canTravel() {
        System.out.println("Ruler can travel?");
        super.canTravel();
        return true;
    }

    @Override
    public boolean canPerformGenocide() {
        return false;
    }

    @Override
    public void vote() {
        System.out.println("Great Ruler I voted with 25000 votes");
    }
}
