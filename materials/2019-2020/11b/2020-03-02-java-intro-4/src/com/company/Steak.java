package com.company;

public class Steak implements IBakable {
    @Override
    public void bake(Skara bbq) {
        System.out.println("Baking the steak...");
    }
}
