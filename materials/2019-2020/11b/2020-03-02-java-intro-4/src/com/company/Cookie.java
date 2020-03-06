package com.company;

public class Cookie extends Food implements IBakable, IFryable {
    Cookie() {
        super("Cookie");
    }

    Cookie(String name) {
        super(name);
    }

    @Override
    void print_nutritional_value() {
        System.out.println("I have 200 calories");
    }

    @Override
    public void bake(Skara bbq) {
        System.out.println("Baking the " + name + "...");
    }

    @Override
    public void fry(Skara bbq) {
        System.out.println("Frying the " + name + "...");
    }
}
