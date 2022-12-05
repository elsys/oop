package org.elsys_bg.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest extends AbstractTestClass {

    @Test
    void sum() {
        int result = c.sum(1, 2);

        assertEquals(3, result);
    }

    @Test
    void minus_positiveNumber_negativeNumber() {
        //Given
//        c.test =0;

        //When
        int result = c.minus(2);

        //Then
        assertEquals(-2, result);
    }

    @Test
    void minus_negativeNumber_positiveNumber() {
        int result = c.minus(-2);

        assertEquals(2, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, 18, Integer.MAX_VALUE}) // six numbers
    void isOdd_ShouldReturnTrueForOddNumbers(int number) {
        c.isOdd(number);
        assertTrue(c.isOdd(number));
    }

    @Test
    public void test_defaultValues() {
        Calculator c = new Calculator();

        assertEquals(0, c.a);
        assertEquals(0, c.b);
    }

    @Test
    public void divide_zero_exception() {
        assertThrows(IllegalArgumentException.class, () -> c.divide(1, 1));
    }
}