package ru.job4j.softreferences;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class SoftCacheTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void addToCashAndGetFromCash() throws IOException {
        File sourceFile = folder.newFile("HelloWorld.txt");
        try (PrintWriter out = new PrintWriter(sourceFile)) {
            out.println("Hello world!");
            out.println("Hello world!");
        }
        String exp = new StringJoiner(System.lineSeparator()).add("Hello world!").add("Hello world!").toString();
        String rsl = new SoftCache().get(sourceFile.getAbsolutePath());
        assertThat(rsl, is(exp));
    }

    @Test
    public void getFromCash() throws IOException {
        File sourceFile = folder.newFile("HelloWorld.txt");
        try (PrintWriter out = new PrintWriter(sourceFile)) {
            out.println("Hello world!");
            out.println("Hello world!");
        }
        Cache<String> cache = new SoftCache();
        String exp = new StringJoiner(System.lineSeparator()).add("Hello world!").add("Hello world!").toString();
        cache.get(sourceFile.getAbsolutePath());
        String rsl = cache.get(sourceFile.getAbsolutePath());
        assertThat(rsl, is(exp));
    }

    @Test
    public void notPossibleToGetFileAndGetNull() {
        Cache<String> cache = new SoftCache();
        assertNull(cache.get("NotFoundFile.txt"));
    }
}