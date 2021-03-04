import org.junit.jupiter.api.*;

class MainTest {
    Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void factorielSeven() {
        int result = main.factoriel(7);
        Assertions.assertEquals(5040, result);
    }

    @Test
    void factorielFive() {
        int result = main.factoriel(5);
        Assertions.assertEquals(120, result);
    }

    @Test
    void factorielOne() {
        int result = main.factoriel(1);
        Assertions.assertEquals(1, result);
    }

    @Test
    void factorielMinusOne() {
        int result = main.factoriel(-1);
        Assertions.assertEquals(1, result);
    }

    @Test
    void factorielOneThousand() {
        //int result = main.factoriel(900);
        //System.out.println(result);
        //Assertions.assertTrue(result > 1000);

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> main.factoriel(1000)
        );
    }
}