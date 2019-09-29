package org.elsys.postfix;

public class Sqrt extends UnaryOperation {

    public Sqrt(Calculator calculator) {
        super("sqrt", calculator);
    }

    @Override
    protected double calculate(double arg) {
        return Math.sqrt(arg);
    }
}
