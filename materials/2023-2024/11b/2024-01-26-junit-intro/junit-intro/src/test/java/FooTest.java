import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FooTest {

    @Test
    void addPositive() {

            Foo add1 = new Foo();
            int a = 5;
            int b = 3;
            int result = add1.add(a,b);

            assertEquals(8, result);

        }
        @Test
 void addNegative() {

    Foo add1 = new Foo();
    int a = -1;
    int b = -2;
    int result = add1.add(a,b);

    assertEquals(-3, result);

    }
}