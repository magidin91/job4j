package ru.job4j.io;

import java.io.File;
import java.util.*;
import java.util.function.Predicate;

/**
 * Метод возвращает список всех файлов в директории, исключая те, что не удовлетворяют условию
 */
class Search {
    List<File> files(String parent, Predicate<File> predicate) {
        List<File> rsl = new ArrayList<>();
        File root = new File(parent);
        Queue<File> data = new LinkedList<>();
        data.offer(root);
        while (!data.isEmpty()) {
            File el = data.poll();
            if (el.isDirectory()) {
                data.addAll(Arrays.asList(el.listFiles()));
            } else {
                if (predicate.test(el)) {
                    rsl.add(el);
                }
            }
        }
        return rsl;
    }

    /**
     * Метод возвращает предикат для получения файлов с указанными расширениями
     */
    public Predicate<File> getPredicateWithList(List<String> exts) {
        return file -> {
            String name = file.getName();
            for (String suffix : exts) {
                if (name.endsWith(suffix)) {
                    return true;
                }
            }
            return false;
        };
    }

    /**
     * Метод возвращает предикат для получения файлов, исключая файлы с указанными расширениями
     */
    public Predicate<File> getPredicateWithoutList(List<String> exts) {
        return file -> {
            String name = file.getName();
            for (String suffix : exts) {
                if (name.endsWith(suffix)) {
                    return false;
                }
            }
            return true;
        };
    }
}