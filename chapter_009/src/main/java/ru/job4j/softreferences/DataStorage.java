package ru.job4j.softreferences;

public interface DataStorage<K, V> {
    /**
     * Returns the value by the key or null if it is not possible to retrieve an object using this key.
     */
    V getValue(K key);
}
