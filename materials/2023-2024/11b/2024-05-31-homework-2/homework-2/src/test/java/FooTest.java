import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FooTest {

    Foo foo;

    @BeforeEach
    void setUp() {
        foo = new Foo();
    }

    @Test
    void barThrowsAnError() {
        assertThrows(Exception.class, () -> foo.bar(6));
        assertThrowsExactly(Exception.class, () -> foo.bar(6));
        assertDoesNotThrow(() -> foo.bar(4));

//        Exception res = null;
//
//        try {
//            foo.bar(6);
//        } catch (Exception err) {
//            res = err;
//        }
//
//        assertNotEquals(null, res);
//        assertInstanceOf(Exception.class, res);
//        assertEquals("My exception", res.getMessage());
    }

    @Test
    void run() {
        mock(Thread);
        when(Thread.sleep).then(() -> {
            // do nothing
        });
        assertDoesNotThrow(() -> foo.run());
        assertCalledWith(Thread.sleep, 10000);

        when(Thread.sleep).then(() -> {
            throw new InterruptedException();
        });
        assertThrows(RuntimeException.class, () -> foo.run());
    }
}