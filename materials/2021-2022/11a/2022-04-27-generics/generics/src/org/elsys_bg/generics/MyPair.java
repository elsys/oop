package org.elsys_bg.generics;

public class MyPair <K extends Comparable<K>, V> implements Pair<K, V>, Comparable<MyPair>{
    private K key;
    private V value;

    public MyPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public MyPair() {

    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public int compareTo(MyPair o) {
        return key.compareTo((K) o.key);
    }
}
