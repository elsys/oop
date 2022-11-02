package org.elsys_bg.inheritance;

public abstract class Animal {
    protected String name;
    private int age;
    private Color color;

    private final int test = 10;//constant

    public Animal(String name, int age, Color color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

//    public Animal() {
//    }

    public abstract void makeSound();

    public void sayHello() {
        System.out.println("Hello!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
