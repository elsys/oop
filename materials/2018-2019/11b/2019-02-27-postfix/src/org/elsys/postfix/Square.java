package org.elsys.postfix;

public class Square extends UnaryOperation {
    public Square(Calculator calculator) {
        super("^2", calculator);
    }

    @Override
    protected double calculate(double arg) {
        return Math.pow(arg, 2);
    }
}
