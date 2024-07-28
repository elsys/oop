import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.*;
import java.util.Random;

@ExtendWith(MockitoExtension.class)
class MainTest {
    @Mock
    Random rand = new Random();

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeAll
    static void setup() {
        System.setOut(new PrintStream(outContent));
        System.setIn(new ByteArrayInputStream("13 14".getBytes()));
    }

    @Test
    void main() {
       Mockito.when(rand.nextInt()).thenReturn(10);
       Main m = new Main(rand);

       m.calc();
       String s = outContent.toString();
       s = s.replaceAll("\r", "");
       assertEquals("10\n13\n", s);
    }
}