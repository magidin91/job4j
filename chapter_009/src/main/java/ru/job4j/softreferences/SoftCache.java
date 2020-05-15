package ru.job4j.softreferences;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class SoftCache implements Cache<String, String> {
    Map<String, SoftReference<String>> cache = new HashMap<>();
    private final DataStorage<String, String> dataStorage;

    public SoftCache(DataStorage<String, String> dataStorage) {
        this.dataStorage = dataStorage;
    }

    @Override
    public String get(String key) {
        String rsl;
        SoftReference<String> softReference = cache.get(key);
        if (softReference != null) {
            rsl = softReference.get();
        } else {
            rsl = dataStorage.read(key);
            addToCache(key, rsl);
        }
        return rsl;
    }

    /**
     * Adds the read string to the cache
     */
    private void addToCache(String key, String rsl) {
        if (rsl != null) {
            SoftReference<String> softValue = new SoftReference<>(rsl);
            cache.put(key, softValue);
        }
    }
}
