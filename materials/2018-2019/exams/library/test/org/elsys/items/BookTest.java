package org.elsys.items;

import org.elsys.ReadingException;
import org.elsys.factory.Factory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private ByteArrayOutputStream outContent;
    private Book book;

    @BeforeEach
    void setUp() {
        book = Factory.createBook("Alexis Zorbas", "Nikos Kazandzakis", Genre.FICTION, 500);
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void getPages() {
        assertEquals(500, book.getPages());
    }

    @Test
    void getTitle() {
        assertEquals("Alexis Zorbas", book.getTitle());
    }

    @Test
    void getAuthor() {
        assertEquals("Nikos Kazandzakis", book.getAuthor());
    }

    @Test
    void getGenre() {
        assertEquals(Genre.FICTION, book.getGenre());
    }

    @Test
    void read() {
        assertEquals("", outContent.toString());
        for (int i = 0; i < 1000; i++) {
            book.read();
            assertEquals("", outContent.toString());
        }
        book.read();
        assertEquals("\"Alexis Zorbas\" is overread.\n", outContent.toString());
    }

    @Test
    void isTooOld() {
        for (int i = 0; i < 1000; i++) {
            assertFalse(book.isTooOld());
            book.read();
        }
        assertTrue(book.isTooOld());
    }
}