package ru.job4j.softreferences;

public interface Cache<K, V> {
    /**
     * This method returns a value from the cache by the key or null if there is no value with this key.
     */
    V get(K key);

    /**
     * Returns true if value was added to the cache.
     * If value is null, it is not added to the cache and the method returns false.
     */
    boolean put(K key, V value);
}
