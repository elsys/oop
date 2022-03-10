package org.elsys_bg.inheritance;

import java.io.ObjectStreamException;
// reading material: https://docs.oracle.com/javase/tutorial/java/IandI/index.html
public class Main {

    public static void main(String[] args) {

        Bmw bmw = new Bmw(2002);
        Automobile b = bmw;
        Car c = bmw;
        Racable r = bmw;

        bmw.turnWheel();

        Object o = bmw;
    }
}
