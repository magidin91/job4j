package ru.job4j.softreferences;

/**
 * A program that emulates cache behavior
 */
public class CacheEmulation<K, V> {
    private final Cache<K, V> cache;
    private final DataStorage<K, V> dataStorage;

    public CacheEmulation(Cache<K, V> cache, DataStorage<K, V> dataStorage) {
        this.cache = cache;
        this.dataStorage = dataStorage;
    }

    /**
     * This method returns an value from the cache by the key.
     * If the key is not in the cache, the value is added to the cache from the storage.
     * Returns null if it is not possible to retrieve a value using this key from the storage.
     */
    public V get(K key) {
        V value = cache.get(key);
        if (value == null) {
            value = dataStorage.getValue(key);
            cache.put(key, value);
        }
        return value;
    }
}
