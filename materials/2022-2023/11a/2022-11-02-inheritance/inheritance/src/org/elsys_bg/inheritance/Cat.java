package org.elsys_bg.inheritance;

public final class Cat extends Mammals implements Walk {
    public String name;
    private int age;
    private Color color;

    public Cat(String name, int age, Color color) {
        super(name, age, color);
        this.name = "Cat";
        this.age = 10;
    }

    @Override
    public void makeSound() {
        System.out.println("Meow");
    }

    @Override
    public String getName() {
        super.name = "asd";
        return super.getName();
    }

    @Override
    public void sayHello() {
        this.age = 10;
        super.sayHello();
//        System.out.println("Hello!");
        System.out.println("Meow");
    }

    public void test() {
        super.setAge(12);
    }

//    public void walk() {
//        System.out.println("I am cat and I am walking");
//    }
}
