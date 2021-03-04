import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @AfterEach
    void tearDown() {
    }
    // 0 1 1 2 3 5 8 13 ...
    /*@Test
    void fibonacciSecond() {
        int result = main.fibonacci(2);
        assertEquals(1, result);
    }

    @Test
    void fibonacciFifth() {
        int result = main.fibonacci(5);
        assertEquals(5, result);
    }

    @Test
    void fibonacciSeventh() {
        int result = main.fibonacci(7);
        assertEquals(13, result);
    }


    @Test
    void fibonacciMinusFirst() {
        //int result = main.fibonacci(-1);
        //assertEquals(-5, result);

        assertThrows(
                IllegalArgumentException.class,
                () -> main.fibonacci(-1)
        );
    }

    @Test
    void fibonacciMultiple() {
        int[] arguments = {0, 1, 3, 10, 15, 25};
        int[] expected = {0, 1, 2, 55, 610, 75025};

        for(int i = 0; i < arguments.length; i++) {
            assertEquals(
                    expected[i],
                    main.fibonacci(arguments[i])
            );
        }
    }
*/
    @Test
    void fibonacciTooBig() {
        BigInteger result = main.fibonacci(40);
        assertTrue(
                result.compareTo(
                        new BigInteger("50")
                ) >= 0
        );
    }
}