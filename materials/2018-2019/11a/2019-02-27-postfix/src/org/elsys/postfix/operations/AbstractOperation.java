package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;
import org.elsys.postfix.Operation;

public abstract class AbstractOperation implements Operation {

    private Calculator calculator;

    private String name;

    public AbstractOperation(Calculator calculator, String name) {
        this.calculator = calculator;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    protected Calculator getCalculator() {
        return calculator;
    }
}
