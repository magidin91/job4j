package ru.job4j.stream.api.improvements;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ScopeGroupe {
    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream().sorted(Comparator.nullsLast(Student::compareTo)).flatMap(Stream::ofNullable).takeWhile(student -> student.getScope() > bound).
                collect(Collectors.toList());
    }
}
