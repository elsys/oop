package test.java;
import main.java.Cat;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class CatTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    Cat kote = new Cat("Zlati");

    @org.junit.jupiter.api.BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @org.junit.jupiter.api.AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }


    @Test
    void giveBirth() {
        
    }

    @Test
    void sayName() {
    }

    @Test
    void getName() {
    }

    @Test
    void swim() {
    }

    @Test
    void walk() {
    }
}
