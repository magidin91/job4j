package ru.job4j.io;

import java.io.File;
import java.util.*;
import java.util.function.Predicate;

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
}