package org.elsys.duzunov;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Histogram<T> implements Iterable<Map.Entry<T, Integer>> {
    private final ArrayList<T> elements = new ArrayList<>();
    private final HashMap<T, Integer> elementCount = new HashMap<>();

    public Histogram(Collection<T> collection) {
        for (T element : collection) {
            if (!elementCount.containsKey(element)) {
                elements.add(element);
            }
            elementCount.merge(element, 1, Integer::sum);
        }
    }

    private class Entry implements Map.Entry<T, Integer> {
        private final T key;
        private final Integer value;

        public Entry(T key, Integer value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public T getKey() {
            return key;
        }

        @Override
        public Integer getValue() {
            return value;
        }

        @Override
        public Integer setValue(Integer value) {
            throw new UnsupportedOperationException();
        }
    }

    private class Iterator
            implements java.util.Iterator<Map.Entry<T, Integer>> {
        private int iteratedElements = 0;

        @Override
        public boolean hasNext() {
            return iteratedElements < elements.size();
        }

        @Override
        public Map.Entry<T, Integer> next() {
            T element = elements.get(iteratedElements);
            Entry entry = new Entry(element, elementCount.get(element));
            ++iteratedElements;
            return entry;
        }
    }

    @Override
    public java.util.Iterator<Map.Entry<T, Integer>> iterator() {
        return new Iterator();
    }
}
