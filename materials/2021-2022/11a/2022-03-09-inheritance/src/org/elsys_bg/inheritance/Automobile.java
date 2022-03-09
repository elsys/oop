package org.elsys_bg.inheritance;

public interface Automobile {
    //all varables are constants and are public
    String name = "asdas";
    static void brummm() {
        System.out.println("bumm");
    }
    //all methods are public
    void turnWheel();
    void changeGear();
    void applyGas();
    void applyBreak();
}
