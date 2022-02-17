package org.elsys_bg.Bike.simple;

public class Bike {
    /*
    class variable
        <access modifier> <other modificators> <type> <name>
     */
    /*
    access modifiers:
    public
    protect
    private
    package private - classes int the same package see them as public, others see them as private
     */
    private int speed;
    private int gear;
    //final == const
    private final int id;
    private static int counter = 0;
    /*
    constructor
    <access modifier> <class name>
     */
    //default constructor
    public Bike(int id) {
        this.id = id;
        speed = 0;
        gear = 1;
        counter ++;
    }
    //constructor overloading
    //speed and gear local variables
    public Bike(int speed, int gear, int id) {
        this.speed = speed;
        this.gear = gear;
        this.id = id;
    }
//    public Bike (int gear, int speed) {
//
//    }
    public Bike(int speed, int id) {
        this.speed = speed;
        this.id = id;
        gear = 1;
    }

    /*
    class methods
    <access modifier> <additional modifiers> <return type> <method name> <parameters>
     */

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public int getSpeed(int test) {
        return 0;
    }

    public static int getCounter() {
        return counter;
    }

//    public void test(int[] value) {
//
//    }

    public void test(int... values) {
        int length = values.length;
        int value = values[0];
    }
}
