package org.elsys_bg.map;

import java.util.Objects;

public class CompositeKey {
    private Integer integer;
    private String string;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeKey that = (CompositeKey) o;
        return Objects.equals(integer, that.integer) && Objects.equals(string, that.string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(integer, string);
    }
}
