package org.elsys_bg.inheritance;

public class Pudel extends Dog{
    public Pudel(String name, int age, Color color) {
        super(name, age, color);
    }

    //can't override final methods
//    public int test() {
//        return 3;
//    }
}
