package org.elsys.duzunov;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
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

    @Override
    public Iterator<Map.Entry<T, Integer>> iterator() {
        // Тук дефинираме анонимен клас, имплементиращ java.util.Iterator
        // интерфейса
        return new Iterator<>() {
            private final Iterator<T> elementsIterator = elements.iterator();

            @Override
            public boolean hasNext() {
                return elementsIterator.hasNext();
            }

            @Override
            public Map.Entry<T, Integer> next() {
                T element = elementsIterator.next();
                return new Entry(element, elementCount.get(element));
            }
        };
    }

    // Дефиниция на метода за взимане на итератор, използваща локален клас
    // В случая е по-удачно да използваме анонимен клас (вижте горната
    // дефиниция), тъй като използваме локалния клас само веднъж
    public Iterator<Map.Entry<T, Integer>> iteratorUsingLocalClass() {
        class Iterator implements java.util.Iterator<Map.Entry<T, Integer>> {
            private final java.util.Iterator<T> elementsIterator =
                    elements.iterator();

            @Override
            public boolean hasNext() {
                return elementsIterator.hasNext();
            }

            @Override
            public Map.Entry<T, Integer> next() {
                T element = elementsIterator.next();
                return new Entry(element, elementCount.get(element));
            }
        }

        return new Iterator();
    }
}
