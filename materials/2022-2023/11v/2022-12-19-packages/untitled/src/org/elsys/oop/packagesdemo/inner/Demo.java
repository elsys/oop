package org.elsys.oop.packagesdemo.inner;

import static java.lang.Math.pow;
import static java.lang.Math.*;

public class Demo {
    int var = 0;

    public void doWork() {
        //Math.pow(Math.abs(Math.min(5, Math.PI)), Math.cos(12));
        pow(abs(min(5, PI)), cos(12));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Demo demo = (Demo) o;

        return var == demo.var;
    }

    @Override
    public int hashCode() {
        return var;
    }
}
