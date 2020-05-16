package ru.job4j.softreferences;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class SoftCache<K, V> implements Cache<K, V> {
    private final Map<K, SoftReference<V>> map = new HashMap<>();

    @Override
    public V get(K key) {
        V rsl = null;
        SoftReference<V> softReference = map.get(key);
        if (softReference != null) {
            rsl = softReference.get();
        }
        return rsl;
    }

    @Override
    public boolean put(K key, V value) {
        boolean rsl = false;
        if (value != null) {
            SoftReference<V> softValue = new SoftReference<>(value);
            map.put(key, softValue);
            rsl = true;
        }
        return rsl;
    }
}

