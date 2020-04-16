package org.elsys.duzunov;

public class Util {
    // Генеричен статичен метод (Generic static method),
    // използващ собствени типови параметри
    public static <K, V> boolean areEqual(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
                p1.getValue().equals(p2.getValue());
    }
}
