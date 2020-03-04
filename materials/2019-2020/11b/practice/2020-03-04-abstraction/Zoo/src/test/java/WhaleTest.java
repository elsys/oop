package test.java;
import main.java.Whale;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class WhaleTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    Whale kit = new Whale("Johnny");

    @org.junit.jupiter.api.BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @org.junit.jupiter.api.AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @org.junit.jupiter.api.Test
    void giveBirth() {
        //System.out.println("I am " + getName() +  "the whale and I am swimming");
        kit.giveBirth();
        assertEquals("I am mammal and I am giving birth\n", outContent.toString());
    }


    @org.junit.jupiter.api.Test
    void sayName() {
        kit.sayName();
        assertEquals("My name is Johnny\n", outContent.toString());
    }

    @org.junit.jupiter.api.Test
    void getName() {
        assertEquals("Johnny", kit.getName());

    }

    @org.junit.jupiter.api.Test
    void swim() {
        kit.swim();
        assertEquals("I am Johnny the whale and I am swimming\n", outContent.toString());
    }
}
