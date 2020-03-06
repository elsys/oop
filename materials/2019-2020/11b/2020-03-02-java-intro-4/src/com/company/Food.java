package com.company;

public abstract class Food {
    String name;
    Food() {
        this("unknown food");
    }
    Food(String name) {
        this.name = name;
    }

    abstract void print_nutritional_value();
}
