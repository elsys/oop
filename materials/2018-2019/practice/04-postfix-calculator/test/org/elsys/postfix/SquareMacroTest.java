package org.elsys.postfix;

import org.junit.jupiter.api.Test;

public class SquareMacroTest extends CalculatorAbstractTest {

	@Test
	public void test() {
		input("\\square");
		input("dup");
		input("*");
		input("def");
		
		input("2");
		input("square");
		
		runCalculator();
		assertCalculatorLastValue(4.0);
	}

}
