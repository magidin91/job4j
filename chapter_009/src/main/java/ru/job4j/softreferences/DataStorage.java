package ru.job4j.softreferences;

public interface DataStorage<K, V> {
    /**
     * Returns a value from the storage
     */
    V read(K key);
}
