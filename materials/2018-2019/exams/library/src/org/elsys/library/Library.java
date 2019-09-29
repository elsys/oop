package org.elsys.library;

import org.elsys.items.ReadableItem;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Library {

    public double getBorderPercent() {
        return 0;
    }

    public Collection<ReadableItem> getItems() {
        return null;
    }

    public int getItemCount(ReadableItem item) {
        return 0;
    }

    public void buyItem(ReadableItem item) {

    }

    public void buyItem(ReadableItem item, int count) {

    }


    public void scrapItem(ReadableItem item) {

    }
    
    public void lendItem(ReadableItem item) {

    }

    public void returnItem(ReadableItem item) {

    }

    public Collection<ReadableItem> getItemsByAuthor(String author) {
        return null;
    }

    public Map<Integer, List<ReadableItem>> getBooksGroupedByCount() {
        return null;
    }
}
