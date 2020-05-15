package ru.job4j.softreferences;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class SoftCache implements Cache<String> {
    Map<String, SoftReference<String>> cache = new HashMap<>();
    private static final Logger LOG = LoggerFactory.getLogger(SoftCache.class.getName());

    @Override
    public String get(String key) {
        String rsl;
        SoftReference<String> softReference = cache.get(key);
        if (softReference != null) {
            rsl = softReference.get();
        } else {
            rsl = readFile(key);
            addToCache(key);
        }
        return rsl;
    }

    /**
     * Adds the read string to the cache
     */
    private void addToCache(String key) {
        String rsl = readFile(key);
        if (rsl != null) {
            SoftReference<String> softValue = new SoftReference<>(rsl);
            cache.put(key, softValue);
        }
    }

    /**
     * Reads data from a file
     * Returns null if it is not possible to retrieve a data from a file.
     */
    private String readFile(String key) {
        String rsl = null;
        try (BufferedReader read = new BufferedReader(new FileReader(key))) {
            StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
            read.lines().forEach(stringJoiner::add);
            rsl = stringJoiner.toString();
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return rsl;
    }
}
