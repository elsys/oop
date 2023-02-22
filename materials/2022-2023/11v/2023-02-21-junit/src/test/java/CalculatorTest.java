import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calc;

    @BeforeEach
    void gosho() {
        calc = new Calculator(5);
    }

    @AfterEach
    void tearDown() {
        calc = null;
    }

    @Test
    void add() {
        int result = calc.add(8);

        assertEquals(13, result);
    }

    @Test
    void addNegative() {
        assertEquals(-3, calc.add(-8));
    }
}