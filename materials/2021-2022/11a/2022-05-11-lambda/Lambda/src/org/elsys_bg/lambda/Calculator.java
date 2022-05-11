package org.elsys_bg.lambda;

import java.util.function.BinaryOperator;

public class Calculator {

    public int binaryOperation(int a, int b, BinaryOperator<Integer> operator) {
        return operator.apply(a, b);
    }

    public int unaryOperation(){
        return 2;
    };
}
