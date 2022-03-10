package org.elsys_bg.inheritance;

public class M3 extends Bmw{
    public M3(int year) {
        super(year);
    }

    @Override
    public void turnWheel() {
        super.something();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
