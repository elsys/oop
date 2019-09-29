package org.elsys.postfix;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MultiplicationTest extends CalculatorAbstractTest {

	@Test
	public void testWithNotEnoughValuesInStack() {
		input("11");
		input("*");
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
		input("11");
		input("11");
		input("*");
		inputCtrlC();
		runCalculator();
		assertCalculatorLastValue(121);
		assertCalculatorStackSize(1);
	}
}
