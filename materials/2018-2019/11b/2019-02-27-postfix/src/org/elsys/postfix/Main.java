package org.elsys.postfix;

public class Main {

    public static void main(String[] args) {
	    Calculator calculator = new Calculator();
	    calculator.addOperation(new Sqrt(calculator));
	    calculator.addOperation(new Square(calculator));
	    calculator.run(System.in, System.out);
    }
}
