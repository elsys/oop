package org.elsys.items;

import org.elsys.ReadingException;
import org.elsys.factory.Factory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagazineTest {

    private Magazine magazine;

    @BeforeEach
    void setUp() {
        magazine = Factory.createMagazine("National Geographic", "Famous people", Genre.SCIENTIFIC, 88);
    }

    @Test
    void getPages() {
        assertEquals(88, magazine.getPages());
    }

    @Test
    void getTitle() {
        assertEquals("National Geographic", magazine.getTitle());
    }

    @Test
    void getAuthor() {
        assertEquals("Famous people", magazine.getAuthor());
    }

    @Test
    void getGenre() {
        assertEquals(Genre.SCIENTIFIC, magazine.getGenre());
    }

    @Test
    void read() {
        for (int i = 0; i < 500; i++) {
            magazine.read();
        }
        assertThrows(ReadingException.class, magazine::read);
    }

    @Test
    void isTooOld() {
        for (int i = 0; i < 500; i++) {
            assertFalse(magazine.isTooOld());
            magazine.read();
        }
        assertTrue(magazine.isTooOld());
    }
}