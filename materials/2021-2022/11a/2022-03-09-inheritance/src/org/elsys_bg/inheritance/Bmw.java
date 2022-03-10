package org.elsys_bg.inheritance;

//Java does not allow multiple inheritance
public class Bmw extends Car implements Racable{
    private int gears;
    public Bmw(int year) {
        gears = 6;
    }

    @Override
    public void race() {
    }

    @Override
    public void playMusic() {
        System.out.println("I am bmw and I am playing music");
    }

    @Override
    public void turnWheel() {
        System.out.println("I am BMW and I am turning the wheel");
        super.turnWheel();
        super.applyBreak();
    }
}
