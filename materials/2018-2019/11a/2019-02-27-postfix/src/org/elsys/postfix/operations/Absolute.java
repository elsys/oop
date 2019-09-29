package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;
import org.elsys.postfix.Operation;

public class Absolute extends UnaryOperation {

    public Absolute(Calculator calculator) {
        super(calculator, "abs");
    }

    @Override
    protected double calculate(double value) {
        return value < 0 ? -value : value;
    }
}
