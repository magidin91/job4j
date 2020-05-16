package ru.job4j.softreferences;

public interface DataStorage<K, V> {
    /**
     * Returns a value from storage by the key
     */
    V get(K key);
}
