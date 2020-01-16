package ru.job4j.collection.stream.api;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix {
    public static void main(String[] args) {
        Integer[][] matrix = {{1, 2}, {3, 4}};
        System.out.println(Stream.of(matrix).flatMap(Stream::of).collect(Collectors.toList()));
    }
}
