import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DataServerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void generatePackages() {
        Random rand = mock(Random.class);

        // The mock will return 2 on the first call, then 1 on the second and any other call
        when(rand.nextInt()).thenReturn(2, 1);
        // We need to mock nextLong separately because it's a different method
        when(rand.nextLong()).thenReturn(15L);

        DataServer testServer = new DataServer(10, rand);

        List<Package> result = testServer.generatePackages();
        assertEquals(2, result.size());
        // This works by internally calling the Package.equals method
        assertEquals(new Package("PUBG", 15), result.get(0));
    }
}