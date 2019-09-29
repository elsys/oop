package org.elsys.postfix;

public abstract class BaseOperation implements Operation {

    private String name;

    private Calculator calculator;

    public BaseOperation(String name, Calculator calculator) {
        this.name = name;
        this.calculator = calculator;
    }

    @Override
    public String getName() {
        return name;
    }

    protected Calculator getCalculator() {
        return calculator;
    }
}
