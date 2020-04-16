package org.elsys.duzunov;

public interface Cache<K, V> {
    /**
     * Returns the value associated with the key, if it is present in the cache, or
     * null otherwise.
     */
    V get(K key);

    /**
     * Adds the value to the cache and associates it with the key, if both key and
     * value are not null. If key or value (or both) are null, the method does nothing.
     * If the key is already present in the cache, replaces the old value with the
     * currently supplied. If the cache is full, exactly one existing item is removed
     * - the one suggested by the respective eviction policy - and the new key-value pair is added
     */
    void set(K key, V value);

    /**
     * Removes the item associated with the specified key from the cache.
     * Returns true, if an item with the specified key was found and false otherwise.
     */
    boolean remove(K key);

    /**
     * Returns the number of all actual items stored currently in the cache.
     */
    long size();

    /**
     * Removes all items in the cache and resets the hit rate.
     */
    void clear();

    /**
     * Returns the percentage of the successful hits for this cache. It is a
     * double-precision number in the interval [0.0, 1.0] and is equal to the ratio
     * of get(K, V) calls that returned a non-null value versus the calls that
     * returned null. If there is not a single successful hit, the hit rate is 0.0.
     * If there is at least one successful hit and the missed hits are zero, the hit
     * rate is 1.0
     */
    double getHitRate();

    /**
     * Returns the number of times that the value of the given key has been accessed.
     * Returns 0 if the key is not present in the cache.
     */
    int getUsesCount(K key);
}
