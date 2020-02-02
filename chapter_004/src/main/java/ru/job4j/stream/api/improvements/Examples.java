package ru.job4j.stream.api.improvements;

import java.util.List;

public class Examples {
    public static void main(String[] args) {
        List.of(2, 4, 3, 4).stream()
                .takeWhile(v -> v % 2 == 0)
                .map(v -> String.format(" %s", v))
                .forEach(System.out::print);
    }

}
