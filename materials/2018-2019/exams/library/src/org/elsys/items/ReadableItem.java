package org.elsys.items;

public interface ReadableItem {

    String getTitle();

    String getAuthor();

    Genre getGenre();

    int getPages();

    void read();

    boolean isTooOld();

}
