package ru.job4j.io;

import java.io.File;
import java.util.*;

class Search {
    List<File> files(String parent, List<String> exts) {
        List<File> rsl = new ArrayList<>();
        File root = new File(parent);
        Queue<File> data = new LinkedList<>();
        data.offer(root);
        while (!data.isEmpty()) {
            File el = data.poll();
            if (el.isDirectory()) {
                data.addAll(Arrays.asList(el.listFiles()));
            } else {
                String name = el.getName();
                for (String suffix : exts) {
                    if (name.endsWith(suffix)) {
                        rsl.add(el);
                    }
                }
            }
        }
        return rsl;
    }
}