package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;
import org.elsys.postfix.Operation;

public class Negate extends UnaryOperation {

    public Negate(Calculator calculator) {
        super(calculator, "neg");
    }

    @Override
    protected double calculate(double value) {
        return -value;
    }
}
