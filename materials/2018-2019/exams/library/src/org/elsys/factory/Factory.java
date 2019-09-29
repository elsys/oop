package org.elsys.factory;

import org.elsys.items.Book;
import org.elsys.items.Genre;
import org.elsys.items.Magazine;
import org.elsys.library.Library;

public class Factory {

    public static Book createBook(String title, String author, Genre genre, int pages) {
        return null;
    }

    public static Magazine createMagazine(String title, String author, Genre genre, int pages) {
        return null;
    }

    public static Library createLibrary() {
        return null;
    }

    public static Library createLibrary(int borderPercent) {
        return null;
    }
}
