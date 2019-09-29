package org.elsys.library;

import org.elsys.ReadingException;
import org.elsys.factory.Factory;
import org.elsys.items.Book;
import org.elsys.items.Genre;
import org.elsys.items.Magazine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;
    private Magazine magazine;
    private Book book;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        library = Factory.createLibrary();
        magazine = Factory.createMagazine("National Geographic", "Famous people", Genre.SCIENTIFIC, 88);
        library.buyItem(magazine, 4);
        book = Factory.createBook("Alexis Zorbas", "Nikos Kazandzakis", Genre.FICTION, 500);
        library.buyItem(book);

        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void getBorderPercent() {
        assertEquals(75, library.getBorderPercent());
    }

    @Test
    void buyItem() {
        assertTrue(library.getItems().contains(book));
    }

    @Test
    void buyItem1() {
        assertTrue(library.getItems().contains(magazine));
        assertEquals(4, library.getItemCount(magazine));
    }

    @Test
    void scrapItem() {
        library.scrapItem(magazine);
        assertEquals(3, library.getItemCount(magazine));
    }

    @Test
    void lendItem() {
        for (int i = 4; i > 0; i--) {
            assertEquals(i, library.getItemCount(magazine));
            library.lendItem(magazine);
        }
        assertEquals("80.0% items lent.\n", outContent.toString());
        assertEquals(0, library.getItemCount(magazine));
        assertThrows(ReadingException.class, () -> library.lendItem(magazine));
    }

    @Test
    void returnItem() {
        library.lendItem(magazine);
        assertEquals(3, library.getItemCount(magazine));
        library.returnItem(magazine);
        assertEquals(4, library.getItemCount(magazine));
        assertThrows(ReadingException.class, () -> library.returnItem(magazine));
    }
}