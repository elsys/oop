package org.elsys.postfix;

public abstract class UnaryOperation extends BaseOperation {

    public UnaryOperation(String name, Calculator calculator) {
        super(name, calculator);
    }

    @Override
    public void execute() {
        double value = getCalculator().pop();
        double result = calculate(value);
        getCalculator().push(result);
    }

    protected abstract double calculate(double arg);
}
