package org.elsys.duzunov;

public class Pair<K, V> {
    private K key;
    private V value;

    // Генеричен конструктор (Generic constructor),
    // използващ типовите параметри на класа
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // Генерични методи (Generic methods),
    // използващи типовите параметри на класа
    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
