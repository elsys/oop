package org.elsys.postfix;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MinusTest extends CalculatorAbstractTest {

	@Test()
	public void testWithNotEnoughValuesInStack() {
		input("11");
		input("-");
		inputCtrlC();
		assertThrows(EmptyStackException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				runCalculator();
			}
		});
	}

	@Test
	public void test() {
		input("10");
		input("11");
		input("-");
		inputCtrlC();
		runCalculator();
		assertCalculatorLastValue(-1);
		assertCalculatorStackSize(1);
	}

	@Test
	public void testDoublePlus() {
		input("10");
		input("11");
		input("12");
		input("-");
		input("-");
		inputCtrlC();
		runCalculator();
		assertCalculatorLastValue(11);
		assertCalculatorStackSize(1);
	}
}
