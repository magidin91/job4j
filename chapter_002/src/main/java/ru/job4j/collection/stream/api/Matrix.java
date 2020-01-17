package ru.job4j.collection.stream.api;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix {
    public static void main(String[] args) {
        Integer[][] matrix = {{1, 2}, {3, 4}};
        System.out.println(Stream.of(matrix).flatMap(Stream::of).collect(Collectors.toList()));

        List<List<Integer>> list = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );
        System.out.println(
                list.stream().flatMap(Collection::stream).collect(Collectors.toList())
        );
    }
}
