package ru.job4j.softreferences;

public interface Cache<K, V> {
    /**
     * This method returns an object from the cache by the key.
     * If the key is not in the cache, the object is added to the cache.
     * Returns null if it is not possible to retrieve an object using this key from the memory.
     */
    V get(K key);
}
