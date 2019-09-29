package org.elsys.postfix;

import org.junit.jupiter.api.Test;

public class CosTest extends CalculatorAbstractTest {

	@Test
	public void test() {
		input("10");
		input("cos");
		inputCtrlC();
		runCalculator();
		assertCalculatorLastValue(Math.cos(10));
	}

}
