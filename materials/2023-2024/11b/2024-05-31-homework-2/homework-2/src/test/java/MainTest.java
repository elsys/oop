import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @mock
    ExecutorService ex;

    @Test
    void main() {
        Main m = new Main();
        m.ex = ex;

        m.main();
        assertEquals(3, ex.submit.calls);
    }
}