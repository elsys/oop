package org.elsys.postfix;

import org.elsys.postfix.operations.Absolute;
import org.elsys.postfix.operations.Negate;

public class Main {

    public static void main(String[] args) {
	    Calculator calculator = new Calculator();
        calculator.addOperation(new Negate(calculator));
        calculator.addOperation(new Absolute(calculator));
	    calculator.run(System.in, System.out);
    }
}
