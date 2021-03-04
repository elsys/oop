package org.elsys.mbenov;

public class Imperator extends Ruler {
    public Imperator(String name, int age) {
        super(name, age);
    }

    @Override
    public boolean canPerformGenocide() {
        return true;
    }
}
