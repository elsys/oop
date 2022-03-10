package org.elsys_bg.inheritance;

//Can't crate objects of abstract classes
public abstract class Car implements Automobile{
    private int year;

    public abstract void playMusic();

//    public Car(int year) {
//        this.year = year;
//    }

    @Override
    public void turnWheel() {
        System.out.println("I am car and wheel is turning");
    }

    @Override
    public void changeGear() {

    }

    @Override
    public void applyGas() {

    }

    @Override
    public void applyBreak() {
        System.out.println("I am car and I am appalling break");
    }

    final public void something() {

    }
}
