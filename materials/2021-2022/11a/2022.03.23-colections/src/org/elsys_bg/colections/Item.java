package org.elsys_bg.colections;

import java.util.Objects;

public class Item implements Comparable<Item> {
    private final int id;

    public Item(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                '}';
    }

    @Override
    public int compareTo(Item o) {
        return Integer.compare(id, o.id) * -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
