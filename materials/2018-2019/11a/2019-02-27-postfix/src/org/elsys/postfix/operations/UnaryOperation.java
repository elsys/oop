package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;

public abstract class UnaryOperation extends AbstractOperation {

    public UnaryOperation(Calculator calculator, String name) {
        super(calculator, name);
    }

    @Override
    public void execute() {
        double value = getCalculator().pop();
        getCalculator().push(calculate(value));
    }

    protected abstract double calculate(double value);
}
