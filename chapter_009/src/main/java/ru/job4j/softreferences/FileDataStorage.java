package ru.job4j.softreferences;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class FileDataStorage implements DataStorage<String, String> {
    private static final Logger LOG = LoggerFactory.getLogger(SoftCache.class.getName());

    /**
     * Reads data from a file.
     * Returns null if it is not possible to retrieve a data from a file.
     */
    @Override
    public String get(String path) {
        String rsl = null;
        try (BufferedReader read = new BufferedReader(new FileReader(path))) {
            rsl = read.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return rsl;
    }
}
