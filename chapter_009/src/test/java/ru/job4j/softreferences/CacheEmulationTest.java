package ru.job4j.softreferences;

import org.junit.Test;

import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class CacheEmulationTest {
    @Test
    public void addToCashAndGetFromCash() {
        String exp = new StringJoiner(System.lineSeparator()).add("Hello world!").add("Hello world!").toString();
        CacheEmulation<String, String> cache = new CacheEmulation<>(new SoftCache<>(), key -> exp);
        String rsl = cache.get("");
        assertThat(rsl, is(exp));
    }

    @Test
    public void getFromCash() {
        String exp = new StringJoiner(System.lineSeparator()).add("Hello world!").add("Hello world!").toString();
        CacheEmulation<String, String> cache = new CacheEmulation<>(new SoftCache<>(), key -> exp);
        cache.get("");
        String rsl = cache.get("");
        assertThat(rsl, is(exp));
    }

    @Test
    public void notPossibleToGetFileAndGetNull() {
        CacheEmulation<String, String> cache = new CacheEmulation<>(new SoftCache<>(), new FileDataStorage());
        assertNull(cache.get("NotFoundFile.txt"));
    }
}